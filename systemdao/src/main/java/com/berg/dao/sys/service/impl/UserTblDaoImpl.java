package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.UserTbl;
import com.berg.dao.sys.mapper.UserTblMapper;
import com.berg.dao.sys.service.UserTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户信息表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@Repository
public class UserTblDaoImpl extends ServiceImpl<UserTblMapper, UserTbl> implements UserTblDao {

    @Override
    public UserTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
