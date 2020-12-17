package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.ApiFallback;
import com.berg.common.constant.Result;
import com.berg.dao.page.PageInfo;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApiEditVo;
import com.berg.vo.request.ApiVo;
import com.berg.vo.request.in.GetApiPageInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="api", fallback = ApiFallback.class)
public interface ApiService {

    @ApiOperation("获取请求接口分页列表")
    @GetMapping(value = "getApiPage")
    Result<PageInfo<ApiVo>> getApiPage(@Validated GetApiPageInVo input);

    @ApiOperation("获取请求接口")
    @GetMapping(value = "getApi")
    Result<ApiEditVo> getApi(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("新增请求接口")
    @PostMapping(value = "addApi")
    Result<Integer> addApi(@RequestBody @Validated ApiEditVo input);

    @ApiOperation("修改请求接口")
    @PutMapping(value = "updateApi")
    Result<Integer> updateApi(@RequestBody @Validated ApiEditVo input);

    @ApiOperation("删除请求接口")
    @DeleteMapping(value = "delApi")
    Result<Boolean> delApi(@RequestBody EntityIdVo<Integer> input);
}
