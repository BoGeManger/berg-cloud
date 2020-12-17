package com.berg.dao.system.res.service;

import com.berg.dao.system.res.entity.ApiTbl;
import com.berg.dao.base.IService;
import com.berg.dao.system.res.mapper.ApiTblMapper;

/**
 * <p>
 * 请求接口表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
public interface ApiTblDao extends IService<ApiTbl> {
   ApiTblMapper getMapper();
}
