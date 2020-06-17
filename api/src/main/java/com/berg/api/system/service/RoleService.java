package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.RoleFallback;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.RoleEditVo;
import com.berg.vo.system.RoleVo;
import com.berg.vo.system.in.GetRolePageInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="role", fallback = RoleFallback.class)
public interface RoleService {

    @ApiOperation("获取角色分页列表")
    @GetMapping(value = "/system/role/getRolePage")
    Result getRolePage(@Validated GetRolePageInVo input);
    @ApiOperation("获取角色")
    @GetMapping(value = "/system/role/getRole")
    Result getRole(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("新增角色")
    @PostMapping(value = "/system/role/addRole")
    Result addRole(@RequestBody @Validated RoleEditVo input);

    @ApiOperation("修改角色")
    @PutMapping(value = "/system/role/updateRole")
    Result updateRole(@RequestBody @Validated RoleEditVo input);

    @ApiOperation("删除角色")
    @DeleteMapping(value = "/system/role/delRole")
    Result delRole(@RequestBody EntityIdVo<Integer> input);
}
