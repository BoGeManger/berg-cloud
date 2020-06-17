package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.LoginFallback;
import com.berg.message.Result;
import com.berg.vo.system.in.LoginInVo;
import com.berg.vo.system.out.LoginOutVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "system" ,contextId="login", fallback = LoginFallback.class)
public interface LoginService {

    @ApiOperation(value = "用户登录",notes = "无需登录校验")
    @PostMapping(value = "/system/login/login")
    Result login(@RequestBody @Validated LoginInVo input);
}
