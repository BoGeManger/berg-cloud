package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.ComponentService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.OperatorBatchComInVo;
import org.springframework.stereotype.Component;

@Component
public class ComponentFallback implements ComponentService {

    @Override
    public Result getComTree() {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result getCom(Integer id) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result operatorBatchCom(OperatorBatchComInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }
}
