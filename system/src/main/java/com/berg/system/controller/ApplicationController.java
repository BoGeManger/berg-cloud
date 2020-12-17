package com.berg.system.controller;

import com.berg.common.base.BaseController;
import com.berg.common.constant.Result;
import com.berg.dao.page.PageInfo;
import com.berg.system.service.request.ApplicationService;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApplicationEditVo;
import com.berg.vo.request.ApplicationVo;
import com.berg.vo.request.in.GetApplicationPageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Api(tags = "请求应用管理")
public class ApplicationController extends BaseController {

    @Autowired
    ApplicationService applicationService;

    @ApiOperation("获取请求应用分页列表")
    @GetMapping(value = "getApplicationPage")
    public Result<PageInfo<ApplicationVo>> getApplicationPage(@Validated GetApplicationPageInVo input){
        return getSuccessResult("请求成功",applicationService.getApplicationPage(input));
    }

    @ApiOperation("获取请求应用")
    @GetMapping(value = "getApplication")
    public Result<ApplicationEditVo> getApplication(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return getSuccessResult("请求成功",applicationService.getApplication(id));
    }

    @ApiOperation("新增请求应用")
    @PostMapping(value = "addApplication")
    public Result<Integer> addApplication(@RequestBody @Validated ApplicationEditVo input){
        return getSuccessResult("请求成功",applicationService.addApplication(input));
    }

    @ApiOperation("修改请求应用")
    @PutMapping(value = "updateApplication")
    public Result<Integer> updateApplication(@RequestBody @Validated ApplicationEditVo input){
        return getSuccessResult("请求成功",applicationService.updateApplication(input));
    }

    @ApiOperation("修改请求应用密钥")
    @PutMapping(value = "updateApplicationSecret")
    public Result<Boolean> updateApplicationSecret(@RequestBody EntityIdVo<Integer> input){
        applicationService.updateApplicationSecret(input.getId());
        return getSuccessResult("请求成功",true);
    }

    @ApiOperation("删除请求应用")
    @DeleteMapping(value = "delApplication")
    public Result<Boolean> delApplication(@RequestBody EntityIdVo<Integer> input){
        applicationService.delApplication(input.getId());
        return getSuccessResult("请求成功",true);
    }
}
