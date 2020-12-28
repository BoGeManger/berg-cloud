package com.berg.auth.system.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SystemConstants {

    @Value("${auth.system.urls:default}")
    String urls;

    @Value("${auth.system.accounts:default}")
    String accounts;

    @Value("${auth.system.expireTime:7200}")
    Integer expireTime;

}
