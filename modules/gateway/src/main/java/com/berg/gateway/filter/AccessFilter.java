package com.berg.gateway.filter;

import com.berg.auth.system.auth.AuthenticationFilter;
import com.berg.auth.system.constant.AuthConstants;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.gateway.service.impl.AccessStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.naming.AuthenticationException;

@Slf4j
@Configuration
public class AccessFilter implements GlobalFilter {

    @Autowired
    AccessStrategy accessStrategy;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain){
        ServerHttpRequest request = serverWebExchange.getRequest();
        String thisUrl = request.getPath().pathWithinApplication().value();
        String serviceName =  thisUrl.split("/")[1];
        try{
            accessStrategy.isAccessAllowed(serviceName,request,thisUrl);
        }catch (AuthenticationException ex){
            log.error("网关请求授权失败:"+ex.getMessage());
            return writeWithUnauth(serverWebExchange,ex.getMessage());
        }
        return gatewayFilterChain.filter(serverWebExchange.mutate().request(request.mutate().build()).build());
    }

    /**
     * 生成授权错误返回
     * @param serverWebExchange
     * @param message
     * @return
     */
    Mono<Void> writeWithUnauth(ServerWebExchange serverWebExchange,String message){
        Result result = new Result(MessageConstants.UNAUTH_ERROR_CODE, "请求授权错误", message,HttpStatus.UNAUTHORIZED);
        return writeWith(serverWebExchange,result);
    }

    /**
     * 生成返回
     * @param serverWebExchange
     * @param result
     * @return
     */
    Mono<Void> writeWith(ServerWebExchange serverWebExchange, Result result){
        HttpHeaders httpHeaders = serverWebExchange.getResponse().getHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        serverWebExchange.getResponse().setStatusCode(result.getHttpStatus());
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = null;
        try{
            bytes = mapper.writeValueAsBytes(result);
        }catch (Exception ex){
            log.error("网关返回序列化失败:"+ex);
        }
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }
}
