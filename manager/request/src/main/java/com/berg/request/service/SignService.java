package com.berg.request.service;

public interface SignService {

    void checkSign(String callerService,String appName,String requestPath,String timestamp,String sign);

    String getApplicationSecret(String callerService,String appName,String requestPath);
}
