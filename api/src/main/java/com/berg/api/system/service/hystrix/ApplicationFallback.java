package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.ApplicationService;
import com.berg.dao.page.PageInfo;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApplicationEditVo;
import com.berg.vo.request.ApplicationVo;
import com.berg.vo.request.in.GetApplicationPageInVo;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFallback implements ApplicationService {

    @Override
    public Result<PageInfo<ApplicationVo>> getApplicationPage(GetApplicationPageInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<ApplicationEditVo> getApplication(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Integer> addApplication(ApplicationEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Integer> updateApplication(ApplicationEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Boolean> updateApplicationSecret(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Boolean> delApplication(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
