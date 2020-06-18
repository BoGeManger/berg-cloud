package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.QuartzJobTbl;
import com.berg.dao.sys.mapper.QuartzJobTblMapper;
import com.berg.dao.sys.service.QuartzJobTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统定时任务表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@Repository
public class QuartzJobTblDaoImpl extends ServiceImpl<QuartzJobTblMapper, QuartzJobTbl> implements QuartzJobTblDao {

    @Override
    public QuartzJobTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
