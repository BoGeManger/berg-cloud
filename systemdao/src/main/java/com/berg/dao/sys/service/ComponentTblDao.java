package com.berg.dao.sys.service;

import com.berg.dao.sys.entity.ComponentTbl;
import com.berg.dao.base.IService;
import com.berg.dao.sys.mapper.ComponentTblMapper;

/**
 * <p>
 * 系统组件表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
public interface ComponentTblDao extends IService<ComponentTbl> {
   ComponentTblMapper getMapper();
}
