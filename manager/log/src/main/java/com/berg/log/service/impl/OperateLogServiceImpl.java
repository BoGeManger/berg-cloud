package com.berg.log.service.impl;
import java.time.LocalDateTime;

import com.berg.auth.system.auth.AuthenticationUtil;
import com.berg.common.constant.AppConstants;
import com.berg.dao.log.entity.OperateLogTbl;
import com.berg.dao.log.service.OperateLogTblDao;
import com.berg.log.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    AuthenticationUtil authenticationUtil;

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
        operateLogTbl.setOperateUser(authenticationUtil.getUsername());
        operateLogTbl.setType(type);
        operateLogTblDao.save(operateLogTbl);
    }

}
