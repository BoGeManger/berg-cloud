package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.ComponentFallback;
import com.berg.common.constant.Result;
import com.berg.vo.system.in.OperatorBatchComInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="com", fallback = ComponentFallback.class)
public interface ComponentService {

    @ApiOperation("获取组件树形列表")
    @GetMapping(value = "/system/com/getComTree")
    Result getComTree();

    @ApiOperation("获取组件")
    @GetMapping(value = "/system/com/getCom")
    Result getCom(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("批量操作组件(新增,修改,删除)")
    @PostMapping(value = "/system/com/operatorBatchCom")
    Result operatorBatchCom(@RequestBody @Validated OperatorBatchComInVo input);

}
