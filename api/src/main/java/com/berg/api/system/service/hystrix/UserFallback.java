package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.UserService;
import com.berg.dao.page.PageInfo;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.UserEditVo;
import com.berg.vo.system.UserVo;
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
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result addUser(UserEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result updateUser(UserEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result delUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result lockUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result unlockUser(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result updatePassword(UpdatePasswordInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
