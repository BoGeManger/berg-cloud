package com.berg.dao.system.res.service;

import com.berg.dao.system.res.entity.ApplicationTbl;
import com.berg.dao.base.IService;
import com.berg.dao.system.res.mapper.ApplicationTblMapper;

/**
 * <p>
 * 请求应用表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
public interface ApplicationTblDao extends IService<ApplicationTbl> {
   ApplicationTblMapper getMapper();
}
