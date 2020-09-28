package com.berg.api.system.service.hystrix;

import com.berg.api.system.service.ApiService;
import com.berg.dao.page.PageInfo;
import com.berg.message.MessageConstant;
import com.berg.message.Result;
import com.berg.vo.common.EntityIdVo;
import com.berg.vo.request.ApiEditVo;
import com.berg.vo.request.ApiVo;
import com.berg.vo.request.in.GetApiPageInVo;
import org.springframework.stereotype.Component;

@Component
public class ApiFallback implements ApiService {

    @Override
    public Result<PageInfo<ApiVo>> getApiPage(GetApiPageInVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<ApiEditVo> getApi(Integer id) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Integer> addApi(ApiEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Integer> updateApi(ApiEditVo input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }

    @Override
    public Result<Boolean> delApi(EntityIdVo<Integer> input) {
        return new Result(MessageConstant.USER_FRIENDLY_ERROR_CODE,"网络延迟，请稍后重试","");
    }
}
