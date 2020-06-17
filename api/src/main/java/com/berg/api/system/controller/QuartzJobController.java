package com.berg.api.system.controller;

import com.berg.api.system.service.QuartzJobService;
import com.berg.dao.page.PageInfo;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.JobEditVo;
import com.berg.vo.system.JobVo;
import com.berg.vo.system.in.GetJobPageInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/quartzjob")
@Api(tags = "定时任务管理")
public class QuartzJobController {

    @Autowired
    QuartzJobService quartzJobService;

    @ApiOperation("获取定时任务分页")
    @GetMapping(value = "getJobPage")
    public Result<PageInfo<JobVo>> getJobPage(@Validated GetJobPageInVo input){
        return quartzJobService.getJobPage(input);
    }

    @ApiOperation("获取定时任务")
    @GetMapping(value = "getJob")
    public Result<JobEditVo> getJob(@ApiParam(value = "表id",required = true) @RequestParam Integer id){
        return quartzJobService.getJob(id);
    }

    @ApiOperation("新增定时任务")
    @PostMapping(value = "addJob")
    public Result<Integer> addJob(@RequestBody @Validated JobEditVo input){
        return quartzJobService.addJob(input);
    }

    @ApiOperation("删除定时任务")
    @DeleteMapping(value = "delJob")
    public Result<Boolean> delJob(@RequestBody EntityIdVo<Integer> input){
        return quartzJobService.delJob(input);
    }

    @ApiOperation("暂停定时任务")
    @PutMapping(value = "pauseJob")
    public Result<Boolean> pauseJob(@RequestBody EntityIdVo<Integer> input){
        return quartzJobService.pauseJob(input);
    }

    @ApiOperation("启动定时任务")
    @PutMapping(value = "resumeJob")
    public Result<Boolean> resumeJob(@RequestBody EntityIdVo<Integer> input){
        return quartzJobService.resumeJob(input);
    }
}


