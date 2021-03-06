package com.berg.generator.system.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.berg.dao.constant.DataSource;
import com.berg.generator.config.rules.NamingStrategy;

/**
 * 生成配置
 */
public class GeneratorConfig{

    //模块路径
    public final static String PATH = "/dao/system-dao/src/main/java";

    //基础模块包
    public final static String BASE_MODULE_NAME= "com.berg.dao";
    //region 多数据源标识配置
    //数据库主模块名称
    public final static String PARENT_MODULE_NAME = DataSource.SYSTEM;
    //多数据源标识
    public final static String DS = "DataSource.SYSTEM";
    //endregion

    //region 输出配置
    //是否仅输出模版文本(默认false)
    public final static Boolean ONLYSTR= false;
    //是否文件覆盖(默认false)
    public final static Boolean FILE_OVERRIDE = false;

    //是否输出Entity(默认true)
    public final static Boolean GENERATE_ENTITY = true;
    //是否输出Mapper(默认true)
    public final static Boolean GENERATE_MAPPER = true;
    //是否输出Dao(默认true)
    public final static Boolean GENERATE_DAO = true;
    //是否输出DaoImpl(默认true)
    public final static Boolean GENERATE_DAO_IMPL = true;
    //是否输出Xml(默认true)
    public final static Boolean GENERATE_XML = true;
    //是否输出业务逻辑(包含Controller,Vo,EditVo,PageInVo,Service,ServiceImpl,单表结构增删改查,默认false)
    public final static Boolean GENERATE_BUSINESS = false;
    //endregion

    //region 输出模块配置
    //是否模块化输出(默认true)
    public final static Boolean GENERATE_MODULE  =true;
    //是否名称根据模块过滤(默认true)
    public final static Boolean FILTER_MODULE_NAME = true;
    //endregion

    //region 数据库配置
    //数据库类型
    public final static DbType DBTYPE = DbType.MYSQL;
    //数据库访问地址
    public final static String URL = "jdbc:mysql://localhost:3306/clouddb?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
    //数据库驱动
    public final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库用户名
    public final static String USER_NAME = "root";
    //数据库密码
    public final static String PASSWORD = "123456";
    //postgresql数据库访问模块
    public final static String SCHEMA_NAME = "public";
    //数据库表映射到实体的命名策略
    public final static NamingStrategy NAMING = NamingStrategy.underline_to_camel;
    //数据库表字段映射到实体的命名策略
    public final static NamingStrategy COLUMN_NAMING = NamingStrategy.underline_to_camel;
    //endregion
}
