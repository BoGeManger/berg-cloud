package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.ComponentTbl;
import com.berg.dao.sys.mapper.ComponentTblMapper;
import com.berg.dao.sys.service.ComponentTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统组件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@Repository
public class ComponentTblDaoImpl extends ServiceImpl<ComponentTblMapper, ComponentTbl> implements ComponentTblDao {

    @Override
    public ComponentTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
