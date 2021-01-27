package com.berg.gateway.controller;

import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/defaultFallback")
    public Result defaultFallback(){
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }
}
