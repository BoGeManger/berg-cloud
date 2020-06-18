package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.OrganizationTbl;
import com.berg.dao.sys.mapper.OrganizationTblMapper;
import com.berg.dao.sys.service.OrganizationTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统组织表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@Repository
public class OrganizationTblDaoImpl extends ServiceImpl<OrganizationTblMapper, OrganizationTbl> implements OrganizationTblDao {

    @Override
    public OrganizationTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
