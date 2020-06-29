package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.LoginService;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.system.in.LoginInVo;
import com.berg.vo.system.out.LoginOutVo;
import org.springframework.stereotype.Component;

@Component
public class LoginFallback implements LoginService {

    @Override
    public Result login(LoginInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
