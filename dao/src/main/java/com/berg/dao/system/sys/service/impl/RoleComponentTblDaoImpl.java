package com.berg.dao.system.sys.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.berg.dao.system.sys.entity.RoleComponentTbl;
import com.berg.dao.system.sys.mapper.RoleComponentTblMapper;
import com.berg.dao.system.sys.service.RoleComponentTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统角色组件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@DS("system")
@Repository
public class RoleComponentTblDaoImpl extends ServiceImpl<RoleComponentTblMapper, RoleComponentTbl> implements RoleComponentTblDao {

    @Override
    public RoleComponentTblMapper getMapper(){
      return this.getBaseMapper();
    }
}