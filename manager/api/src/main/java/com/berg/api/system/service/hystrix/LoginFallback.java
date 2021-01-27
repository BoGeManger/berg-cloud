package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.LoginService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.LoginInVo;
import org.springframework.stereotype.Component;

@Component
public class LoginFallback implements LoginService {

    @Override
    public Result login(LoginInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }
}
