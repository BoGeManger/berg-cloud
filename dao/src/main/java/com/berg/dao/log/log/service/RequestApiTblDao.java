package com.berg.dao.log.log.service;

import com.berg.dao.log.log.entity.RequestApiTbl;
import com.berg.dao.base.IService;
import com.berg.dao.log.log.mapper.RequestApiTblMapper;

/**
 * <p>
 * 请求日志表 服务类
 * </p>
 *
 * @author 
 * @since 2020-09-22
 */
public interface RequestApiTblDao extends IService<RequestApiTbl> {
   RequestApiTblMapper getMapper();
}
