package com.berg.gateway;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableDiscoveryClient
@ComponentScan("com.berg")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run( GatewayApplication.class, args );
    }
}
