package com.berg.api.system.controller;

import com.berg.api.system.service.LoginService;
import com.berg.base.BaseController;
import com.berg.message.Result;
import com.berg.vo.system.in.LoginInVo;
import com.berg.vo.system.out.LoginOutVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/login")
@Api(tags = "用户登录")
public class LoginController{

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "用户登录",notes = "无需登录校验")
    @PostMapping(value = "login")
    public Result<LoginOutVo> login(@RequestBody @Validated LoginInVo input){
        return  loginService.login(input);
    }
}
