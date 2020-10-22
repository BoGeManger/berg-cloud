package com.berg.manager.log.service.impl;
import java.time.LocalDateTime;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.berg.constant.AppConstants;
import com.berg.dao.log.entity.OperateLogTbl;
import com.berg.dao.log.service.OperateLogTblDao;
import com.berg.manager.log.service.OperateLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    AppConstants appConstants;
    @Autowired
    OperateLogTblDao operateLogTblDao;

    @Override
    public void info(String message){
        info(message,"","","");
    }

    @Override
    public void info(String message,String extField1){
        info(message,extField1,"","");;
    }

    @Override
    public void info(String message,String extField1,String extField2){
        info(message,extField1,extField2,"");;
    }

    @Override
    public void info(String message,String extField1,String extField2,String extField3){
        addLog(message,"info",extField1,extField2,extField3);
    }


    @Override
    public void debug(String message){
        debug(message,"","","");
    }

    @Override
    public void debug(String message,String extField1){
        debug(message,extField1,"","");;
    }

    @Override
    public void debug(String message,String extField1,String extField2){
        debug(message,extField1,extField2,"");;
    }

    @Override
    public void debug(String message,String extField1,String extField2,String extField3){
        addLog(message,"debug",extField1,extField2,extField3);
    }


    @Override
    public void error(String message){
        error(message,"","","");
    }

    @Override
    public void error(String message,String extField1){
        error(message,extField1,"","");;
    }

    @Override
    public void error(String message,String extField1,String extField2){
        error(message,extField1,extField2,"");;
    }

    @Override
    public void error(String message,String extField1,String extField2,String extField3){
        addLog(message,"error",extField1,extField2,extField3);
    }


    /**
     * 新增系统日志
     * @param message
     * @param type
     * @param extField1
     * @param extField2
     * @param extField3
     */
    void addLog(String message,String type,String extField1,String extField2,String extField3){
        OperateLogTbl operateLogTbl = new OperateLogTbl();
        operateLogTbl.setService(appConstants.getAppName());
        operateLogTbl.setPort(appConstants.getPort());
        operateLogTbl.setMessage(message);
        operateLogTbl.setExtField1(extField1);
        operateLogTbl.setExtField2(extField2);
        operateLogTbl.setExtField3(extField3);
        operateLogTbl.setOperateTime(LocalDateTime.now());
        operateLogTbl.setOperateUser(getUsername());
        operateLogTbl.setType(type);
        operateLogTblDao.save(operateLogTbl);
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
