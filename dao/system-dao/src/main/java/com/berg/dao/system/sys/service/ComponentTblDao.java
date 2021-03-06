package com.berg.dao.system.sys.service;

import com.berg.dao.system.sys.entity.ComponentTbl;
import com.berg.dao.system.sys.mapper.ComponentTblMapper;
import com.berg.dao.base.IService;

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
