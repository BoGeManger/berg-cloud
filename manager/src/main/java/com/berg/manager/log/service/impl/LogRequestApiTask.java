package com.berg.manager.log.service.impl;
import java.time.LocalDateTime;

import com.berg.constant.AppConstants;
import com.berg.dao.log.log.entity.RequestApiTbl;
import com.berg.dao.log.log.service.RequestApiTblDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogRequestApiTask {

    @Autowired
    AppConstants appConstants;
    @Autowired
    RequestApiTblDao requestApiTblDao;

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
        RequestApiTbl requestApiTbl = new RequestApiTbl();
        requestApiTbl.setService(appConstants.getAppName());
        requestApiTbl.setPort(appConstants.getPort());
        requestApiTbl.setController(controller);
        requestApiTbl.setMethod(method);
        requestApiTbl.setCode(code);
        requestApiTbl.setInput(input);
        requestApiTbl.setOutput(output);
        requestApiTbl.setDescription(description);
        requestApiTbl.setOperateUser(operate);
        requestApiTbl.setOperateTime(LocalDateTime.now());
        requestApiTblDao.save(requestApiTbl);
    }
}
