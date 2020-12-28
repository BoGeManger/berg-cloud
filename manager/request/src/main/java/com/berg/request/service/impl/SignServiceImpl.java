package com.berg.request.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.berg.common.constant.RedisKeyConstants;
import com.berg.common.exception.UnauthException;
import com.berg.common.utils.SignConvertUtil;
import com.berg.dao.system.res.entity.ApplicationTbl;
import com.berg.dao.system.res.service.ApplicationTblDao;
import com.berg.request.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ApplicationTblDao applicationTblDao;

    /**
     * 请求授权校验
     * @param callerService
     * @param appName
     * @param requestPath
     * @param timestamp
     * @param sign
     */
    public void checkSign(String callerService,String appName,String requestPath,String timestamp,String sign){
        String secret = getApplicationSecret(callerService,appName,requestPath);
        String newSign = SignConvertUtil.generateSign(callerService,appName,null,timestamp,secret,requestPath);
        if(!newSign.equals(sign) || !StringUtils.isNotBlank(sign) || !StringUtils.isNotBlank(newSign)){
            throw new UnauthException("授权校验失败");
        }
    }

    /**
     * 获取应用密钥
     * @param callerService
     * @param appName
     * @param requestPath
     * @return
     */
    public String getApplicationSecret(String callerService,String appName,String requestPath){
        String path = appName+requestPath;
        String secret = getApplicationCache(callerService,path);
        if(!StringUtils.isNotBlank(secret)){
            secret = getApplicationData(callerService,path);
        }
        return secret;
    }

    /**
     * 获取请求应用缓存
     * @param callerService
     * @param path
     * @return
     */
    String getApplicationCache(String callerService,String path){
        try{
            String key = String.format(RedisKeyConstants.Request.APPLICATION_API,callerService);
            Map<Object,Object> map = stringRedisTemplate.opsForHash().entries(key);
            if(map.size()>0){
                if(!map.containsKey(path)){
                    throw new UnauthException("您没有对应的访问权限");
                }
                return map.get("secret").toString();
            }
            return "";
        }catch (Exception ex){
            log.error("请求应用校验获取缓存失败:"+ex.getMessage());
            return "";
        }
    }

    /**
     * 获取请求应用数据
     * @param callerService
     * @param path
     * @return
     */
    String getApplicationData(String callerService,String path){
        LambdaQueryWrapper query = new LambdaQueryWrapper<ApplicationTbl>().eq(ApplicationTbl::getName,callerService).eq(ApplicationTbl::getIsdel,0);
        ApplicationTbl applicationTbl = applicationTblDao.getOneLimit(query);
        if(applicationTbl==null){
            throw new UnauthException("您没有对应的访问权限");
        }
        String secret = applicationTbl.getSecret();
        if(!StringUtils.isNotBlank(secret)){
            throw new UnauthException("授权校验失败");
        }
        List<String> perms = applicationTblDao.getMapper().listApplicationApi(callerService);
        if(!perms.contains(path)){
            throw new UnauthException("您没有对应的访问权限");
        }
        //设置缓存
        setApplicationCache(callerService,secret,perms);
        return secret;
    }

    /**
     * 设置请求应用缓存
     * @param callerService
     * @param secret
     * @param perms
     */
    void setApplicationCache(String callerService,String secret,List<String> perms){
        try{
            String key = String.format(RedisKeyConstants.Request.APPLICATION_API,callerService);
            Map<String,String> map = new HashMap<>();
            map.put("secret",secret);
            perms.forEach(item->{
                map.put(item,item);
            });
            stringRedisTemplate.opsForHash().putAll(key,map);
        }catch (Exception ex){
            log.error("请求应用校验设置缓存失败:"+ex.getMessage());
        }
    }
}
