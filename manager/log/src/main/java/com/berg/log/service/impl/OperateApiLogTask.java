package com.berg.log.service.impl;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.berg.common.constant.AppConstants;
import com.berg.dao.log.entity.OperateApiLogTbl;
import com.berg.dao.log.service.OperateApiLogTblDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OperateApiLogTask {

    @Autowired
    AppConstants appConstants;
    @Autowired
    OperateApiLogTblDao operateApiLogTblDao;

    /**
     * 新增请求日志
     * @param requestTime
     * @param controller
     * @param method
     * @param headers
     * @param code
     * @param input
     * @param output
     * @param description
     * @param operate
     */
    @Async
    public void addLog(LocalDateTime requestTime,String controller,String method,String headers,String code,String input,String output,String description,String operate){
        OperateApiLogTbl operateApiLogTbl = new OperateApiLogTbl();
        operateApiLogTbl.setService(appConstants.getAppName());
        operateApiLogTbl.setPort(appConstants.getPort());
        operateApiLogTbl.setController(controller);
        operateApiLogTbl.setMethod(method);
        operateApiLogTbl.setHeaders(headers);
        operateApiLogTbl.setCode(code);
        operateApiLogTbl.setInput(input);
        operateApiLogTbl.setOutput(output);
        operateApiLogTbl.setDescription(description);
        operateApiLogTbl.setOperateUser(operate);
        operateApiLogTbl.setRequestTime(requestTime);
        operateApiLogTbl.setResponseTime(LocalDateTime.now());
        float timeout = (float)LocalDateTimeUtil.between(requestTime,LocalDateTime.now()).toMillis()/1000;
        operateApiLogTbl.setTimeout(new BigDecimal(timeout).setScale(2, BigDecimal.ROUND_HALF_UP));
        operateApiLogTblDao.save(operateApiLogTbl);
    }
}
