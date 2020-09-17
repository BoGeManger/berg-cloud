package com.berg.system.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class QuartzConfig {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        DataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().build();
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
        quartzScheduler.setDataSource(dataSource);
        quartzScheduler.setTransactionManager(new DataSourceTransactionManager(dataSource));
        return quartzScheduler;
    }
}
