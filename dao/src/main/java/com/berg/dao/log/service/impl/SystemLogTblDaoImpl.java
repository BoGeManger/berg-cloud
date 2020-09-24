package com.berg.dao.log.service.impl;

import com.berg.dao.log.entity.SystemLogTbl;
import com.berg.dao.log.mapper.SystemLogTblMapper;
import com.berg.dao.log.service.SystemLogTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
@DS("log")
@Repository("log.SystemLogTblDaoImpl")
public class SystemLogTblDaoImpl extends ServiceImpl<SystemLogTblMapper, SystemLogTbl> implements SystemLogTblDao {

    @Override
    public SystemLogTblMapper getMapper(){
      DynamicDataSourceContextHolder.push("log");
      return this.getBaseMapper();
    }
}
