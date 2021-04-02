package com.xqk.cloud.consumer.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@RibbonClient注解对特定服务进行特定配置（只有在没有引入Eureka时有用）
 *
 * @author 熊乾坤
 * @since 2021-03-21 19:12
 */
//@Configuration
//@RibbonClient(name = "SPRINGBOOTLEARN", configuration = SpringBootLearnRibbonConfig.class)
public class SpringBootLearnRibbonConfig {
    @Bean
    public IPing getIPing() {
        PingUrl pingUrl = new PingUrl(false, "/actuator/health");
        pingUrl.setExpectedContent("{\"status\":\"UP\"}");
        return pingUrl;
    }
}
