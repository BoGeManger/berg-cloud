package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.RoleService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.RoleEditVo;
import com.berg.vo.system.in.GetRolePageInVo;
import org.springframework.stereotype.Component;

@Component
public class RoleFallback implements RoleService {


    @Override
    public Result getRolePage(GetRolePageInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }

    @Override
    public Result getRole(Integer id) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }

    @Override
    public Result addRole(RoleEditVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }

    @Override
    public Result updateRole(RoleEditVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }

    @Override
    public Result delRole(EntityIdVo<Integer> input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网关异常","网络延迟，请稍后重试");
    }
}
