package com.berg.gateway.service;

import org.springframework.http.server.reactive.ServerHttpRequest;

import javax.naming.AuthenticationException;

public interface AccessService {

    String getService();

    void isAccessAllowed(ServerHttpRequest request, String urls)throws AuthenticationException;
}
