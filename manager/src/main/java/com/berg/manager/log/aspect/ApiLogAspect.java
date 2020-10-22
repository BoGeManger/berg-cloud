package com.berg.manager.log.aspect;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.berg.exception.GlobalExceptionHandler;
import com.berg.manager.log.service.impl.OperateApiLogTask;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponseWrapper;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    protected static final ThreadLocal<Map<String,String>> LOCAL_MAP = new ThreadLocal<>();

    @Autowired
    OperateApiLogTask operateApiLogTask;

    @Pointcut("@annotation(com.berg.manager.log.aspect.ApiLog)")
    public void poincut(){

    }

    @Around("poincut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        LocalDateTime now = LocalDateTime.now();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String controller = method.getDeclaringClass().getName();
        String name = method.getName();
        String headers = getHeaders();
        String input = getInput(point,signature);
        String value = getValue(method);
        String operater = getUsername();
        Map<String,String> map = new HashMap<>();
        map.put("now", LocalDateTimeUtil.format(now,"yyyy-MM-dd HH:mm:ss,SSS"));
        map.put("controller",controller);
        map.put("name",name);
        map.put("headers",headers);
        map.put("input",input);
        map.put("value",value);
        map.put("operater",operater);
        LOCAL_MAP.set(map);
        Object result =  point.proceed();
        String output = getOutput(result);
        try{
            operateApiLogTask.addLog(now,controller,name,headers, MessageConstant.SYSTEM_SUCESS_CODE,input,output,value,operater);
        }finally {
            LOCAL_MAP.remove();
        }
        return result;
    }

    @AfterThrowing(value = "poincut()",throwing = "throwable")
    public void afterThrowing(JoinPoint point, Throwable throwable){
        Map<String,String> map = LOCAL_MAP.get();
        Result result = new GlobalExceptionHandler().getResult(throwable,false);
        String output = getOutput(result);
        try{
            operateApiLogTask.addLog(LocalDateTimeUtil.parse(map.get("now"),"yyyy-MM-dd HH:mm:ss,SSS"),map.get("controller"),map.get("name"),map.get("headers"),result.getCode(),map.get("input"),output,map.get("value"),map.get("operater"));
        }finally {
            LOCAL_MAP.remove();
        }
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

    /**
     * 获取请求头部
     * @return
     */
    String getHeaders(){
        String headers = "";
        Map<String,String> map = new HashMap<>();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            map.put(key,request.getHeader(key));
        }
        try{
            headers = JsonHelper.toJson(map,null);
        }catch (Exception ex){
            log.error("ApiLogAspect数据转换失败："+ex.getMessage());
        }
        return headers;
    }
}
