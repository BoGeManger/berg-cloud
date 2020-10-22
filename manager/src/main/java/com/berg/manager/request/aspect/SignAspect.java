package com.berg.manager.request.aspect;

import com.berg.constant.AppConstants;
import com.berg.exception.UnauthException;
import com.berg.manager.request.aspect.Sign;
import com.berg.manager.request.service.SignService;
import com.berg.utils.JsonHelper;
import com.berg.utils.SignConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Enumeration;

@Aspect
@Component
public class SignAspect {

    @Autowired
    AppConstants appConstants;

    @Autowired
    SignService signService;

    @Pointcut("@annotation(com.berg.manager.request.aspect.Sign)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RequestMapping controllerRequestMapping = method.getDeclaringClass().getDeclaredAnnotation(RequestMapping.class);
        String controllerName = controllerRequestMapping.value()[0].replaceAll("/","");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String sign =  request.getHeader("Sign");
        String timestamp =  request.getHeader("Timestamp");
        String service =  request.getHeader("Service");
        String appName = appConstants.getAppName();
        String requestPath = controllerName+"/"+ getMappingValue(method);
        signService.checkSign(service,appName,requestPath,timestamp,sign);
    }

    /**
     * 获取方法注解参数
     * @param method
     * @return
     */
    String getMappingValue(Method method){
        String value = "";
        if(method.isAnnotationPresent(RequestMapping.class)){
            RequestMapping mapping = method.getAnnotation(RequestMapping.class);
            value = mapping.value()[0];
        }else if(method.isAnnotationPresent(GetMapping.class)){
            GetMapping mapping = method.getAnnotation(GetMapping.class);
            value = mapping.value()[0];
        }else if(method.isAnnotationPresent(PostMapping.class)){
            PostMapping mapping = method.getAnnotation(PostMapping.class);
            value = mapping.value()[0];
        }else if(method.isAnnotationPresent(DeleteMapping.class)){
            DeleteMapping mapping = method.getAnnotation(DeleteMapping.class);
            value = mapping.value()[0];
        }else if(method.isAnnotationPresent(PutMapping.class)){
            PutMapping mapping = method.getAnnotation(PutMapping.class);
            value = mapping.value()[0];
        }else if(method.isAnnotationPresent(PatchMapping.class)){
            PatchMapping mapping = method.getAnnotation(PatchMapping.class);
            value = mapping.value()[0];
        }
        return value;
    }
}
