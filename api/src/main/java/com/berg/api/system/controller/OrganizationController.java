package com.berg.api.system.controller;

import com.berg.api.system.service.OrganizationService;
import com.berg.message.Result;
import com.berg.vo.common.ListVo;
import com.berg.vo.system.OrganizationEditVo;
import com.berg.vo.system.OrganizationTreeVo;
import com.berg.vo.system.in.OperatorBatchOrganizationInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/organization")
@Api(tags = "组织管理")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @ApiOperation("获取组织树形列表")
    @GetMapping(value = "getOrganizationTree")
    public Result<ListVo<OrganizationTreeVo>> getOrganizationTree(){
        return organizationService.getOrganizationTree();
    }

    @ApiOperation("获取组织")
    @GetMapping(value = "getOrganization")
    public Result<OrganizationEditVo> getOrganization(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return organizationService.getOrganization(id);
    }

    @ApiOperation("批量操作组织(新增,修改,删除)")
    @PostMapping(value = "operatorBatchOrganization")
    public Result<Boolean> operatorBatchOrganization(@RequestBody @Validated OperatorBatchOrganizationInVo input){
        return organizationService.operatorBatchOrganization(input);
    }

}
