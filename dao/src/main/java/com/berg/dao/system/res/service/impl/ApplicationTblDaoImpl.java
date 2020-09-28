package com.berg.dao.system.res.service.impl;

import com.berg.dao.system.res.entity.ApplicationTbl;
import com.berg.dao.system.res.mapper.ApplicationTblMapper;
import com.berg.dao.system.res.service.ApplicationTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 请求应用表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
@DS("system")
@Repository("system.ApplicationTblDaoImpl")
public class ApplicationTblDaoImpl extends ServiceImpl<ApplicationTblMapper, ApplicationTbl> implements ApplicationTblDao {

    @Override
    public ApplicationTblMapper getMapper(){
      DynamicDataSourceContextHolder.push("system");
      return this.getBaseMapper();
    }
}
