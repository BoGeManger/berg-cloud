package com.berg.manager.log.service.impl;
import java.time.LocalDateTime;

import com.berg.constant.AppConstants;
import com.berg.dao.log.entity.RequestApiLogTbl;
import com.berg.dao.log.service.RequestApiLogTblDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestApiLogTask {

    @Autowired
    AppConstants appConstants;
    @Autowired
    RequestApiLogTblDao requestApiLogTblDao;

    /**
     * 新增请求日志
     * @param controller
     * @param method
     * @param input
     * @param output
     * @param description
     * @param operate
     */
    public void addLog(String controller,String method,String code,String input,String output,String description,String operate){
        RequestApiLogTbl requestApiLogTbl = new RequestApiLogTbl();
        requestApiLogTbl.setService(appConstants.getAppName());
        requestApiLogTbl.setPort(appConstants.getPort());
        requestApiLogTbl.setController(controller);
        requestApiLogTbl.setMethod(method);
        requestApiLogTbl.setCode(code);
        requestApiLogTbl.setInput(input);
        requestApiLogTbl.setOutput(output);
        requestApiLogTbl.setDescription(description);
        requestApiLogTbl.setOperateUser(operate);
        requestApiLogTbl.setOperateTime(LocalDateTime.now());
        requestApiLogTblDao.save(requestApiLogTbl);
    }
}
