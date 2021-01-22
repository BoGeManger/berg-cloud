package com.berg.generator.log;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.berg.generator.AbstractGenerator;
import com.berg.generator.AutoGenerator;
import com.berg.generator.config.*;
import com.berg.generator.engine.FreemarkerTemplateEngine;
import com.berg.generator.log.config.GeneratorConfig;

/**
 * 通用CRUD生成
 */
public class MybatisplusGenerator extends AbstractGenerator {

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + com.berg.generator.system.config.GeneratorConfig.PATH);//路径
        gc.setOpen(false);
        gc.setAuthor("");
        //gc.setSwagger2(true);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setFileOverride(com.berg.generator.system.config.GeneratorConfig.FILE_OVERRIDE);//是否覆盖
        gc.setDs(com.berg.generator.system.config.GeneratorConfig.DS);
        gc.setParentModuleName(com.berg.generator.system.config.GeneratorConfig.PARENT_MODULE_NAME);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(com.berg.generator.system.config.GeneratorConfig.URL);
        dsc.setDriverName(com.berg.generator.system.config.GeneratorConfig.DRIVER_NAME);
        dsc.setUsername(com.berg.generator.system.config.GeneratorConfig.USER_NAME);
        dsc.setPassword(com.berg.generator.system.config.GeneratorConfig.PASSWORD);
        if (com.berg.generator.system.config.GeneratorConfig.DBTYPE == DbType.POSTGRE_SQL) {//postgresql使用
            dsc.setSchemaName(com.berg.generator.system.config.GeneratorConfig.SCHEMA_NAME);
        }
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParentModuleName(com.berg.generator.system.config.GeneratorConfig.PARENT_MODULE_NAME);
        pc.setParent(com.berg.generator.system.config.GeneratorConfig.BASE_MODULE_NAME + StringPool.DOT + com.berg.generator.system.config.GeneratorConfig.PARENT_MODULE_NAME);
        if (com.berg.generator.system.config.GeneratorConfig.GENERATE_MODULE) {
            pc.setModuleName(scanner("模块名"));
        }
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(com.berg.generator.system.config.GeneratorConfig.NAMING);
        strategy.setColumnNaming(com.berg.generator.system.config.GeneratorConfig.COLUMN_NAMING);
        strategy.setEntityLombokModel(true);
        strategy.setChainModel(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(StringPool.COMMA));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + StringPool.UNDERSCORE);
        if (!com.berg.generator.system.config.GeneratorConfig.FILTER_MODULE_NAME) {//不启用名称模块过滤
            strategy.setTablePrefix("");
        }
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_ENTITY) {
            templateConfig.setEntity(null);
        }
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_MAPPER) {
            templateConfig.setMapper(null);
        }
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_DAO) {
            templateConfig.setDao(null);
        }
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_DAO_IMPL) {
            templateConfig.setDaoImpl(null);
        }
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_XML) {
            templateConfig.setXml(null);
        }
        if (!com.berg.generator.system.config.GeneratorConfig.GENERATE_BUSINESS) {
            templateConfig.setVo(null);
            templateConfig.setEditVo(null);
            templateConfig.setPageInVo(null);
            templateConfig.setController(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setTemplate(templateConfig);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        if(GeneratorConfig.ONLYSTR){
            mpg.executeStr();
        }else{
            mpg.execute();
        }
    }
    //endregion
}
