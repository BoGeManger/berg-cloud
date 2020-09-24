package com.berg.manager.log.aspect;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.berg.exception.GlobalExceptionHandler;
import com.berg.manager.log.aspect.annotation.ApiLog;
import com.berg.manager.log.service.impl.RequestApiLogTask;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.utils.JsonHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletResponseWrapper;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    @Autowired
    RequestApiLogTask logRequestApiTask;

    @Pointcut("@annotation(com.berg.manager.log.aspect.annotation.ApiLog)")
    public void poincut(){

    }

    @Around("poincut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result =  point.proceed();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String controller = method.getDeclaringClass().getName();
        String input = getInput(point,signature);
        String value = getValue(method);
        String operater = getUsername();
        String output = getOutput(result);
        logRequestApiTask.addLog(controller,method.getName(), MessageConstant.SYSTEM_SUCESS_CODE,input,output,value,operater);
        return result;
    }

    @AfterThrowing(value = "poincut()",throwing = "throwable")
    public void afterThrowing(JoinPoint point, Throwable throwable){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String controller =  method.getDeclaringClass().getName();
        String input = getInput(point,signature);
        String value = getValue(method);
        String operater = getUsername();
        Result result = new GlobalExceptionHandler().getResult(throwable,false);
        String output = getOutput(result);
        logRequestApiTask.addLog(controller,method.getName(),result.getCode(),input,output,value,operater);
    }

    /**
     * 获取用户
     * @return
     */
    String getUsername() {
        try {
            Subject subject = SecurityUtils.getSubject();
            DecodedJWT jwt = JWT.decode(subject.getPrincipal().toString());
            return jwt.getClaim("username").asString();
        } catch (Exception e) {
            return "system";
        }
    }

    /**
     * 获取描述
     * @param method
     * @return
     */
    String getValue(Method method){
        String value = "";
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        if(apiLog != null){
            value=apiLog.value();
        }
        return value;
    }

    /**
     * 获取输入参数
     * @param point
     * @param signature
     * @return
     */
    String getInput(JoinPoint point,MethodSignature signature){
        String input = "";
        Object[] objs = point.getArgs();
        String[] argNames = signature.getParameterNames();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < objs.length; i++) {
            if (!(objs[i] instanceof ExtendedServletRequestDataBinder) && !(objs[i] instanceof HttpServletResponseWrapper)) {
                paramMap.put(argNames[i], objs[i]);
            }
        }
        if (paramMap.size() > 0) {
            try{
                input = JsonHelper.toJson(paramMap,null);
            }catch (Exception ex){
                log.error("ApiLogAspect数据转换失败："+ex.getMessage());
                return input;
            }
        }
        return input;
    }

    /**
     * 获取输出参数
     * @param result
     * @return
     */
    String getOutput(Object result){
        String ouput = "";
        if(result!=null){
            try{
                ouput = JsonHelper.toJson(result,null);
            }catch (Exception ex){
                log.error("ApiLogAspect数据转换失败："+ex.getMessage());
                return ouput;
            }
        }
        return ouput;
    }

}
