package com.berg.manager.log.service.impl;
import java.time.LocalDateTime;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.berg.constant.AppConstants;
import com.berg.dao.log.entity.SystemLogTbl;
import com.berg.dao.log.service.SystemLogTblDao;
import com.berg.manager.log.service.SystemLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    AppConstants appConstants;
    @Autowired
    SystemLogTblDao systemLogTblDao;

    @Override
    public void info(String message){
        info(message,"");
    }

    @Override
    public void info(String message,String content){
        addLog(message,content,"info");
    }

    @Override
    public void debug(String message){
        debug(message,"");
    }

    @Override
    public void debug(String message,String content){
        addLog(message,content,"debug");
    }

    @Override
    public void error(String message){
        error(message,"");
    }

    @Override
    public void error(String message,String content){
        addLog(message,content,"error");
    }

    /**
     * 新增系统日志
     * @param message
     * @param content
     * @param type
     */
    void addLog(String message,String content,String type){
        SystemLogTbl systemLogTbl = new SystemLogTbl();
        systemLogTbl.setService(appConstants.getAppName());
        systemLogTbl.setPort(appConstants.getPort());
        systemLogTbl.setMessage(message);
        systemLogTbl.setContent(content);
        systemLogTbl.setOperateTime(LocalDateTime.now());
        systemLogTbl.setOperateUser(getUsername());
        systemLogTbl.setType(type);
        systemLogTblDao.save(systemLogTbl);
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
}
