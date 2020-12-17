package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.OrganizationService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.OperatorBatchOrganizationInVo;
import org.springframework.stereotype.Component;

@Component
public class OrganizationFallback implements OrganizationService {


    @Override
    public Result getOrganizationTree() {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result getOrganization(Integer id) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result operatorBatchOrganization(OperatorBatchOrganizationInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }
}
