package com.berg.dao.system.res.service.impl;

import com.berg.dao.constant.DataSource;
import com.berg.dao.system.res.entity.ApplicationApiTbl;
import com.berg.dao.system.res.mapper.ApplicationApiTblMapper;
import com.berg.dao.system.res.service.ApplicationApiTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 请求应用接口表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
@DS(DataSource.SYSTEM)
@Repository("system.ApplicationApiTblDaoImpl")
public class ApplicationApiTblDaoImpl extends ServiceImpl<ApplicationApiTblMapper, ApplicationApiTbl> implements ApplicationApiTblDao {

    @Override
    public ApplicationApiTblMapper getMapper(){
      DynamicDataSourceContextHolder.push(DataSource.SYSTEM);
      return this.getBaseMapper();
    }
}
