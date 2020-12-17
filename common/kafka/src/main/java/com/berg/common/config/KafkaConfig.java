package com.berg.common.config;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 批量消费可以实现此配置
 */
@ConditionalOnProperty(prefix = "spring.kafka", name ="bootstrap-servers")
@Configuration
public class KafkaConfig {

    @Value("${kafka.listener.bootstrap-servers:default}")
    String servers;
    @Value("${kafka.listener.concurrencys:3}")
    Integer concurrency;
    @Value("${kafka.consumer.max-pollrecords:50}")
    Integer maxPollRecordsConfig;
    @Value("${kafka.consumer.auto-offset-reset:earliest}")
    String autoOffsetReset;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<Object, Object> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.getContainerProperties().setPollTimeout(1500);
        //并发数量
        factory.setConcurrency(concurrency);
        //批量获取
        factory.setBatchListener(true);
        return factory;
    }

    public ConsumerFactory<String, String> consumerCarFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerCarConfigs());
    }


    public Map<String, Object> consumerCarConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        //最多批量获取
        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,maxPollRecordsConfig);
        return propsMap;
    }
}
