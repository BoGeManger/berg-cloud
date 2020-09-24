package com.berg.dao.log.service;

import com.berg.dao.log.entity.SystemLogTbl;
import com.berg.dao.base.IService;
import com.berg.dao.log.mapper.SystemLogTblMapper;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
public interface SystemLogTblDao extends IService<SystemLogTbl> {
   SystemLogTblMapper getMapper();
}
