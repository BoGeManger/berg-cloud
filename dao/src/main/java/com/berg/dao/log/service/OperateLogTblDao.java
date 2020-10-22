package com.berg.dao.log.service;

import com.berg.dao.log.entity.OperateLogTbl;
import com.berg.dao.base.IService;
import com.berg.dao.log.mapper.OperateLogTblMapper;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
public interface OperateLogTblDao extends IService<OperateLogTbl> {
   OperateLogTblMapper getMapper();
}
