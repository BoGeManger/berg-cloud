package com.berg.common;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class KafkaMqSender {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    public void send(String topic,Object data) throws Exception{
        send(topic, LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toString(),data);
    }

    public void send(String topic,String key,Object data) throws  Exception{
        String json = JSONUtil.toJsonStr(data);
        this.kafkaTemplate.send(topic,key,json);
    }
}
