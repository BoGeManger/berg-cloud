package com.berg.dao.log.service.impl;

import com.berg.dao.log.entity.RequestApiLogTbl;
import com.berg.dao.log.mapper.RequestApiLogTblMapper;
import com.berg.dao.log.service.RequestApiLogTblDao;
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
@DS("log")
@Repository("log.RequestApiLogTblDaoImpl")
public class RequestApiLogTblDaoImpl extends ServiceImpl<RequestApiLogTblMapper, RequestApiLogTbl> implements RequestApiLogTblDao {

    @Override
    public RequestApiLogTblMapper getMapper(){
      DynamicDataSourceContextHolder.push("log");
      return this.getBaseMapper();
    }
}
