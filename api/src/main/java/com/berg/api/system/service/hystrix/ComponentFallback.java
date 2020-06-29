package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.ComponentService;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.system.in.OperatorBatchComInVo;
import org.springframework.stereotype.Component;

@Component
public class ComponentFallback implements ComponentService {

    @Override
    public Result getComTree() {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result getCom(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result operatorBatchCom(OperatorBatchComInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
