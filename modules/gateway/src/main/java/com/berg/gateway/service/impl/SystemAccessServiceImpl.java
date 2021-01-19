package com.berg.gateway.service.impl;

import com.berg.auth.system.auth.AuthenticationFilter;
import com.berg.auth.system.constant.AuthConstants;
import com.berg.gateway.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

/**
 * system服务授权
 */
@Service
public class SystemAccessServiceImpl implements AccessService {

    @Autowired
    AuthConstants systemConstants;
    @Autowired
    AuthenticationFilter authenticationFilter;

    @Override
    public String getService() {
        return "system";
    }

    @Override
    public void isAccessAllowed(ServerHttpRequest request, String urls) throws AuthenticationException {
        authenticationFilter.isAccessAllowed(request,systemConstants.getUrls());
    }
}
