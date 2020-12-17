package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.OrganizationFallback;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.OperatorBatchOrganizationInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="organization", fallback = OrganizationFallback.class)
public interface OrganizationService {

    @ApiOperation("获取组织树形列表")
    @GetMapping(value = "/system/organization/getOrganizationTree")
    Result getOrganizationTree();

    @ApiOperation("获取组织")
    @GetMapping(value = "/system/organization/getOrganization")
    Result getOrganization(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("批量操作组织(新增,修改,删除)")
    @PostMapping(value = "/system/organization/operatorBatchOrganization")
    Result operatorBatchOrganization(@RequestBody @Validated OperatorBatchOrganizationInVo input);
}
