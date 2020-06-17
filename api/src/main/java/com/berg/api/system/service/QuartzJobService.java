package com.berg.api.system.service;

import com.berg.api.system.service.hystrix.QuartzJobFallback;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.JobEditVo;
import com.berg.vo.system.JobVo;
import com.berg.vo.system.in.GetJobPageInVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "system",contextId="quartzjob", fallback = QuartzJobFallback.class)
public interface QuartzJobService {

    @ApiOperation("获取定时任务分页")
    @GetMapping(value = "/system/quartzjob/getJobPage")
    Result getJobPage(@Validated GetJobPageInVo input);

    @ApiOperation("获取定时任务")
    @GetMapping(value = "/system/quartzjob/getJob")
    Result getJob(@ApiParam(value = "表id",required = true) @RequestParam Integer id);

    @ApiOperation("新增定时任务")
    @PostMapping(value = "/system/quartzjob/addJob")
    Result addJob(@RequestBody @Validated JobEditVo input);

    @ApiOperation("删除定时任务")
    @DeleteMapping(value = "/system/quartzjob/delJob")
    Result delJob(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("暂停定时任务")
    @PutMapping(value = "/system/quartzjob/pauseJob")
    Result pauseJob(@RequestBody EntityIdVo<Integer> input);

    @ApiOperation("启动定时任务")
    @PutMapping(value = "/system/quartzjob/resumeJob")
    Result resumeJob(@RequestBody EntityIdVo<Integer> input);
}
