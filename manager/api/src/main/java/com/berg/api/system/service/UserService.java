package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.UserFallback;
import com.berg.common.constant.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.UserEditVo;
import com.berg.vo.system.in.GetUserPageInVo;
import com.berg.vo.system.in.UpdatePasswordInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="user", fallback = UserFallback.class)
public interface UserService {

    @ApiOperation("获取用户分页列表")
    @GetMapping(value = "/system/user/getUserPage")
    Result getUserPage(@Validated GetUserPageInVo input);

    @ApiOperation("获取用户")
    @GetMapping(value = "/system/user/getUser")
    Result getUser(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("新增用户")
    @PostMapping(value = "/system/user/addUser")
    Result addUser(@RequestBody @Validated UserEditVo input);

    @ApiOperation("修改用户")
    @PutMapping(value = "/system/user/updateUser")
    Result updateUser(@RequestBody @Validated UserEditVo input);

    @ApiOperation("删除用户")
    @DeleteMapping(value = "/system/user/delUser")
    Result delUser(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("锁定用户")
    @PutMapping(value = "/system/user/lockUser")
    Result lockUser(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("解锁用户")
    @PutMapping(value = "/system/user/unlockUser")
    Result unlockUser(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("更新用户密码")
    @PutMapping(value = "/system/user/updatePassword")
    Result updatePassword(@RequestBody @Validated UpdatePasswordInVo input);
}
