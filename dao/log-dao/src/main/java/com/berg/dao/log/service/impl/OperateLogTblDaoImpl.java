package com.berg.dao.log.service.impl;

import com.berg.dao.constant.DataSource;
import com.berg.dao.log.entity.OperateLogTbl;
import com.berg.dao.log.mapper.OperateLogTblMapper;
import com.berg.dao.log.service.OperateLogTblDao;
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
@DS(DataSource.LOG)
@Repository("log.SystemLogTblDaoImpl")
public class OperateLogTblDaoImpl extends ServiceImpl<OperateLogTblMapper, OperateLogTbl> implements OperateLogTblDao {

    @Override
    public OperateLogTblMapper getMapper(){
      DynamicDataSourceContextHolder.push(DataSource.LOG);
      return this.getBaseMapper();
    }
}
