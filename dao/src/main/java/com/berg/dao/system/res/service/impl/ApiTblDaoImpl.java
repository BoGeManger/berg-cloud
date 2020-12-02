package com.berg.dao.system.res.service.impl;

import com.berg.dao.constant.DataSource;
import com.berg.dao.system.res.entity.ApiTbl;
import com.berg.dao.system.res.mapper.ApiTblMapper;
import com.berg.dao.system.res.service.ApiTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 请求接口表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
@DS(DataSource.SYSTEM)
@Repository("system.ApiTblDaoImpl")
public class ApiTblDaoImpl extends ServiceImpl<ApiTblMapper, ApiTbl> implements ApiTblDao {

    @Override
    public ApiTblMapper getMapper(){
      DynamicDataSourceContextHolder.push(DataSource.SYSTEM);
      return this.getBaseMapper();
    }
}
