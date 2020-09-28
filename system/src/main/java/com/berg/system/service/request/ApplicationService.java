package com.berg.system.service.request;

import com.berg.dao.page.PageInfo;
import com.berg.vo.request.ApplicationEditVo;
import com.berg.vo.request.ApplicationVo;
import com.berg.vo.request.in.GetApplicationPageInVo;

public interface ApplicationService {

    PageInfo<ApplicationVo> getApplicationPage(GetApplicationPageInVo input);

    ApplicationEditVo getApplication(Integer id);

    Integer addApplication(ApplicationEditVo input);

    Integer updateApplication(ApplicationEditVo input);

    void delApplication(Integer id);

    void updateApplicationSecret(Integer id);
}
