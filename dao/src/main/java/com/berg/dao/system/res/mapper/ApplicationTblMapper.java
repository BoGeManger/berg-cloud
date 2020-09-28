package com.berg.dao.system.res.mapper;

import com.berg.dao.system.res.entity.ApplicationTbl;
import com.berg.dao.base.BaseMapper;

import java.util.List;

/**
 * <p>
 * 请求应用表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-09-28
 */
public interface ApplicationTblMapper extends BaseMapper<ApplicationTbl> {

    List<String> listApplicationApi(String name);
}
