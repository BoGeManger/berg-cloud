package com.berg.dao.sys.service.impl;

import com.berg.dao.sys.entity.FileTbl;
import com.berg.dao.sys.mapper.FileTblMapper;
import com.berg.dao.sys.service.FileTblDao;
import com.berg.dao.base.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统文件表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-06-18
 */
@Repository
public class FileTblDaoImpl extends ServiceImpl<FileTblMapper, FileTbl> implements FileTblDao {

    @Override
    public FileTblMapper getMapper(){
      return this.getBaseMapper();
    }
}
