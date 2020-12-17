package com.berg.dao.system.sys.service;

import com.berg.dao.system.sys.mapper.UserRoleTblMapper;
import com.berg.dao.system.sys.entity.UserRoleTbl;
import com.berg.dao.base.IService;

/**
 * <p>
 * 系统用户角色表 服务类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
public interface UserRoleTblDao extends IService<UserRoleTbl> {
   UserRoleTblMapper getMapper();
}
