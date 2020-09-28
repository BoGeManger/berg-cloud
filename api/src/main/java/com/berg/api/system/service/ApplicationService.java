package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.ApplicationFallback;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApplicationEditVo;
import com.berg.vo.request.ApplicationVo;
import com.berg.vo.request.in.GetApplicationPageInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="app", fallback = ApplicationFallback.class)
public interface ApplicationService {

    @ApiOperation("获取请求应用分页列表")
    @GetMapping(value = "getApplicationPage")
    Result<PageInfo<ApplicationVo>> getApplicationPage(@Validated GetApplicationPageInVo input);

    @ApiOperation("获取请求应用")
    @GetMapping(value = "getApplication")
    Result<ApplicationEditVo> getApplication(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("新增请求应用")
    @PostMapping(value = "addApplication")
    Result<Integer> addApplication(@RequestBody @Validated ApplicationEditVo input);

    @ApiOperation("修改请求应用")
    @PutMapping(value = "updateApplication")
    Result<Integer> updateApplication(@RequestBody @Validated ApplicationEditVo input);

    @ApiOperation("修改请求应用密钥")
    @PutMapping(value = "updateApplicationSecret")
    Result<Boolean> updateApplicationSecret(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("删除请求应用")
    @DeleteMapping(value = "delApplication")
    Result<Boolean> delApplication(@RequestBody EntityIdVo<Integer> input);

}
