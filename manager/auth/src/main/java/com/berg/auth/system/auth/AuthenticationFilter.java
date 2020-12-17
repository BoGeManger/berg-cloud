package com.berg.auth.system.auth;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.naming.AuthenticationException;

@Component
public class AuthenticationFilter {

    @Autowired
    AuthorizingRealm authorizingRealm;

    public static final String TOKEN = "Authentication";

    /**
     * 授权地址校验
     * @param request
     * @param urls
     * @return
     */
    public void isAccessAllowed(ServerHttpRequest request,String urls)throws AuthenticationException{
        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(urls, ",");
        AntPathMatcher matcher = new AntPathMatcher();
        String thisUrl = request.getPath().pathWithinApplication().value();
        for (String u : anonUrl) {
            if (matcher.match(u, thisUrl)){
                return;
            }
        }
        String token = request.getHeaders().getFirst(TOKEN);
        if (token == null) {
            throw new AuthenticationException("token不存在");
        }
        authorizingRealm.doGetAuthenticationInfo(token);
    }

}
