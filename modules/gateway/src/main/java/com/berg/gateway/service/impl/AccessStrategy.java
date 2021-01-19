package com.berg.gateway.service.impl;

import com.berg.gateway.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AccessStrategy {

    Map<String, AccessService> serviceMap = new HashMap<>();

    @Autowired
    public AccessStrategy(List<AccessService> serviceList){
        for (AccessService service : serviceList) {
            serviceMap.put(service.getService(),service);
        }
    }

    public void isAccessAllowed(String serviceName,ServerHttpRequest request, String urls)throws AuthenticationException{
        AccessService service = serviceMap.get(serviceName);
        if(service!=null){
            service.isAccessAllowed(request,urls);
        }
    }
}
