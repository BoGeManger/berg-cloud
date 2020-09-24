package com.berg.dao.log.service;

import com.berg.dao.log.entity.RequestApiLogTbl;
import com.berg.dao.base.IService;
import com.berg.dao.log.mapper.RequestApiLogTblMapper;

/**
 * <p>
 * 请求日志表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
public interface RequestApiLogTblDao extends IService<RequestApiLogTbl> {
   RequestApiLogTblMapper getMapper();
}
