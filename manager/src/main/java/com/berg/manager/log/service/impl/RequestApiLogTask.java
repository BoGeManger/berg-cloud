package com.berg.manager.log.service.impl;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.berg.constant.AppConstants;
import com.berg.dao.log.entity.RequestApiLogTbl;
import com.berg.dao.log.service.RequestApiLogTblDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RequestApiLogTask {

    @Autowired
    AppConstants appConstants;
    @Autowired
    RequestApiLogTblDao requestApiLogTblDao;

    /**
     * 新增请求日志
     * @param requestTime
     * @param controller
     * @param method
     * @param code
     * @param input
     * @param output
     * @param description
     * @param operate
     */
    @Async
    public void addLog(LocalDateTime requestTime,String controller,String method,String code,String input,String output,String description,String operate){
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
        requestApiLogTbl.setRequestTime(requestTime);
        requestApiLogTbl.setResponseTime(LocalDateTime.now());
        float timeout = (float)LocalDateTimeUtil.between(requestTime,LocalDateTime.now()).toMillis()/1000;
        requestApiLogTbl.setTimeout(new BigDecimal(timeout).setScale(2, BigDecimal.ROUND_HALF_UP));
        requestApiLogTblDao.save(requestApiLogTbl);
    }
}
