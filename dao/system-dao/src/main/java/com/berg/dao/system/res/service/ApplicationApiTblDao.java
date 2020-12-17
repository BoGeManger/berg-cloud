package com.berg.dao.system.res.service;

import com.berg.dao.system.res.entity.ApplicationApiTbl;
import com.berg.dao.base.IService;
import com.berg.dao.system.res.mapper.ApplicationApiTblMapper;

/**
 * <p>
 * 请求应用接口表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
public interface ApplicationApiTblDao extends IService<ApplicationApiTbl> {
   ApplicationApiTblMapper getMapper();
}
