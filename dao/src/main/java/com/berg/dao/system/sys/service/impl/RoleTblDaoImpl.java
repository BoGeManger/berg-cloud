package com.berg.dao.system.sys.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.berg.dao.system.sys.entity.RoleTbl;
import com.berg.dao.system.sys.mapper.RoleTblMapper;
import com.berg.dao.system.sys.service.RoleTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@DS("system")
@Repository
public class RoleTblDaoImpl extends ServiceImpl<RoleTblMapper, RoleTbl> implements RoleTblDao {

    @Override
    public RoleTblMapper getMapper(){
      return this.getBaseMapper();
    }
}