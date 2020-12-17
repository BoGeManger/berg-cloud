package com.berg.domain.log.service;

public interface OperateLogService {

    void info(String message);

    void info(String message,String extField1);
    
    void info(String message,String extField1,String extField2);
    
    void info(String message,String extField1,String extField2,String extField3);
        
    void debug(String message);
    
    void debug(String message,String extField1);
    
    void debug(String message,String extField1,String extField2);
    
    void debug(String message,String extField1,String extField2,String extField3);
    
    void error(String message);
    
    void error(String message,String extField1);
    
    void error(String message,String extField1,String extField2);
    
    void error(String message,String extField1,String extField2,String extField3);
}
