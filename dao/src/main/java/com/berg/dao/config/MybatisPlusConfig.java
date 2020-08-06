package com.berg.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.maiyou.dao.*.*.mapper")
public class MybatisPlusConfig {

}
