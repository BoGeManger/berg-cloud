package com.berg.common.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(prefix = "xxl.job.executor", name ="appname")
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
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        return xxlJobSpringExecutor;
    }

    //需要指定ip可以实现改写这个bean
//    @Bean
//    public XxlJobSpringExecutor xxlJobExecutor(InetUtils inetUtils) {
//        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
//        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
//        xxlJobSpringExecutor.setAppname(appname);
//        if (StringUtils.isBlank(ip)) {
//            ip = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
//        }
//        xxlJobSpringExecutor.setIp(ip);
//        xxlJobSpringExecutor.setPort(port);
//        return xxlJobSpringExecutor;
//    }

}
