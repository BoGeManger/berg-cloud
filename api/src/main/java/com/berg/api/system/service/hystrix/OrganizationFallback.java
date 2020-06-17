package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.OrganizationService;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.ListVo;
import com.berg.vo.system.OrganizationEditVo;
import com.berg.vo.system.OrganizationTreeVo;
import com.berg.vo.system.in.OperatorBatchOrganizationInVo;

public class OrganizationFallback implements OrganizationService {


    @Override
    public Result getOrganizationTree() {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result getOrganization(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result operatorBatchOrganization(OperatorBatchOrganizationInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
