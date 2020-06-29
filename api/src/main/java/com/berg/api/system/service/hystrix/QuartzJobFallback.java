package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.QuartzJobService;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.system.JobEditVo;
import com.berg.vo.system.in.GetJobPageInVo;
import org.springframework.stereotype.Component;

@Component
public class QuartzJobFallback implements QuartzJobService {
    
    @Override
    public Result getJobPage(GetJobPageInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result getJob(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result addJob(JobEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result delJob(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result pauseJob(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result resumeJob(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

}
