package com.berg.dao.log.service.impl;

import com.berg.dao.constant.DataSource;
import com.berg.dao.log.entity.OperateApiLogTbl;
import com.berg.dao.log.mapper.OperateApiLogTblMapper;
import com.berg.dao.log.service.OperateApiLogTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

/**
 * <p>
 * 请求日志表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-09-23
 */
@DS(DataSource.LOG)
@Repository("log.RequestApiLogTblDaoImpl")
public class OperateApiLogTblDaoImpl extends ServiceImpl<OperateApiLogTblMapper, OperateApiLogTbl> implements OperateApiLogTblDao {

    @Override
    public OperateApiLogTblMapper getMapper(){
      DynamicDataSourceContextHolder.push(DataSource.LOG);
      return this.getBaseMapper();
    }
}
