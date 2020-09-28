package com.berg.api.system.controller;

import com.berg.api.system.service.ApiService;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApiEditVo;
import com.berg.vo.request.ApiVo;
import com.berg.vo.request.in.GetApiPageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/api")
@Api(tags = "组件管理")
public class ApiController {

    @Autowired
    ApiService apiService;

    @ApiOperation("获取请求接口分页列表")
    @GetMapping(value = "getApiPage")
    public Result<PageInfo<ApiVo>> getApiPage(@Validated GetApiPageInVo input){
        return apiService.getApiPage(input);
    }

    @ApiOperation("获取请求接口")
    @GetMapping(value = "getApi")
    public Result<ApiEditVo> getApi(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return apiService.getApi(id);
    }

    @ApiOperation("新增请求接口")
    @PostMapping(value = "addApi")
    public Result<Integer> addApi(@RequestBody @Validated ApiEditVo input){
        return apiService.addApi(input);
    }

    @ApiOperation("修改请求接口")
    @PutMapping(value = "updateApi")
    public Result<Integer> updateApi(@RequestBody @Validated ApiEditVo input){
        return apiService.updateApi(input);
    }

    @ApiOperation("删除请求接口")
    @DeleteMapping(value = "delApi")
    public Result<Boolean> delApi(@RequestBody EntityIdVo<Integer> input){
        return apiService.delApi(input);
    }
}
