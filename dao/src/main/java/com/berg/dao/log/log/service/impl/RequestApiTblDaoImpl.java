package com.berg.dao.log.log.service.impl;

import com.berg.dao.log.log.entity.RequestApiTbl;
import com.berg.dao.log.log.mapper.RequestApiTblMapper;
import com.berg.dao.log.log.service.RequestApiTblDao;
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
 * @since 2020-09-22
 */
@DS("log")
@Repository("log.RequestApiTblDaoImpl")
public class RequestApiTblDaoImpl extends ServiceImpl<RequestApiTblMapper, RequestApiTbl> implements RequestApiTblDao {

    @Override
    public RequestApiTblMapper getMapper(){
      DynamicDataSourceContextHolder.push("log");
      return this.getBaseMapper();
    }
}
