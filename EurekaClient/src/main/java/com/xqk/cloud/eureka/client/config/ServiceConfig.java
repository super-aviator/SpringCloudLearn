package com.xqk.cloud.eureka.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author 熊乾坤
 *
 * 从spring cloud config中获取的配置信息，将所有的信息存放在这个配置类中
 *
 * .@RefreshScope需要注解用在需要更新配置的地方（否则没效果咩），然后调用http://localhost/actuator/refresh端点刷新配置（必须在配置文件中暴露Actuator的/refresh端点）
 * */
@Data
@Component
@RefreshScope
public class ServiceConfig {

    @Value(value = "${from}")
    private String from;

    /**
     * password为加密数据，config-server不会对数据进行解密（服务端配置了spring.cloud.config.encrypt.enabled=false）,数据有客户端在注入时进行解密
     */
    @Value(value = "${password}")
    private String password;
}
