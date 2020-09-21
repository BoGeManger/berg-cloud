package com.berg.system.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XxlJobConfig {

    @Value("${xxl.job.admin.addresses}")
    String adminAddresses;

    @Value("${xxl.job.executor.appname}")
    String appname;

    @Value("${xxl.job.executor.ip}")
    String ip;

    @Value("${xxl.job.executor.port}")
    Integer port;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(InetUtils inetUtils) {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        if (StringUtils.isBlank(ip)) {
            ip = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
        }
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        return xxlJobSpringExecutor;
    }

}
