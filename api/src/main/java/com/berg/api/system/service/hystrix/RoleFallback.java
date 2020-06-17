package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.RoleService;
import com.berg.dao.page.PageInfo;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.RoleEditVo;
import com.berg.vo.system.RoleVo;
import com.berg.vo.system.in.GetRolePageInVo;

public class RoleFallback implements RoleService {


    @Override
    public Result getRolePage(GetRolePageInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result getRole(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result addRole(RoleEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result updateRole(RoleEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Boolean> delRole(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
