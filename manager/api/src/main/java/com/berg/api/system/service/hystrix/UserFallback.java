package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.UserService;
import com.berg.common.constant.MessageConstants;
import com.berg.common.constant.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.UserEditVo;
import com.berg.vo.system.in.GetUserPageInVo;
import com.berg.vo.system.in.UpdatePasswordInVo;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserService {


    @Override
    public Result getUserPage(GetUserPageInVo input) {
        return null;
    }

    @Override
    public Result getUser(Integer id) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result addUser(UserEditVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result updateUser(UserEditVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result delUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result lockUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试",null);
    }

    @Override
    public Result unlockUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result updatePassword(UpdatePasswordInVo input) {
        return new Result(MessageConstants.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
