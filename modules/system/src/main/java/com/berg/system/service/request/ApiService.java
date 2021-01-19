package com.berg.system.service.request;

import com.berg.dao.page.PageInfo;
import com.berg.vo.request.ApiEditVo;
import com.berg.vo.request.ApiVo;
import com.berg.vo.request.in.GetApiPageInVo;

public interface ApiService {

    PageInfo<ApiVo> getApiPage(GetApiPageInVo input);

    ApiEditVo getApi(Integer id);

    Integer addApi(ApiEditVo input);

    Integer updateApi(ApiEditVo input);

    void delApi(Integer id);
}
