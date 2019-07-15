package com.xqk.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Aviator
 * <p>
 * 如果使用idea自带的启动按钮启动时报错，则可以尝试使用springboot插件的run目标启动
 * 自己琢磨了半天没启动车工成功，stackoverflow上偶然看到的。。。
 */
@SpringBootApplication
@EnableConfigServer
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
