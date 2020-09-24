package com.berg.manager.log.service;

public interface SystemLogService {

    void info(String message);

    void info(String message,String content);

    void debug(String message);

    void debug(String message,String content);

    void error(String message);

    void error(String message,String content);
}
