package com.berg.system.controller;

import com.berg.common.controller.AbstractController;
import com.berg.common.constant.Result;
import com.berg.dao.page.PageInfo;
import com.berg.system.service.request.ApiService;
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
@RequestMapping("/api")
@Api(tags = "请求接口管理")
public class ApiController extends AbstractController {

    @Autowired
    ApiService apiService;

    @ApiOperation("获取请求接口分页列表")
    @GetMapping(value = "getApiPage")
    public Result<PageInfo<ApiVo>> getApiPage(@Validated GetApiPageInVo input){
        return getSuccessResult("请求成功",apiService.getApiPage(input));
    }

    @ApiOperation("获取请求接口")
    @GetMapping(value = "getApi")
    public Result<ApiEditVo> getApi(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return getSuccessResult("请求成功",apiService.getApi(id));
    }

    @ApiOperation("新增请求接口")
    @PostMapping(value = "addApi")
    public Result<Integer> addApi(@RequestBody @Validated ApiEditVo input){
        return getSuccessResult("请求成功",apiService.addApi(input));
    }

    @ApiOperation("修改请求接口")
    @PutMapping(value = "updateApi")
    public Result<Integer> updateApi(@RequestBody @Validated ApiEditVo input){
        return getSuccessResult("请求成功",apiService.updateApi(input));
    }

    @ApiOperation("删除请求接口")
    @DeleteMapping(value = "delApi")
    public Result<Boolean> delApi(@RequestBody EntityIdVo<Integer> input){
        apiService.delApi(input.getId());
        return getSuccessResult("请求成功",true);
    }
}
