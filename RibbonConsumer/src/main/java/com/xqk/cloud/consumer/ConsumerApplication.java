package com.xqk.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 熊乾坤
 *
 * 可以使用@SpringCloudApplication代替下面的三个注解，这表明一个SpringCloud应用应该包含服务发现和熔断
 * -SpringBootApplication、EnableDiscoveryClient、EnableCircuitBreaker
 *
 * EnableCircuitBreaker注解用于启用Hystrix熔断、EnableHystrixDashboard注解用于启用HystrixDashboard的可视化检测功能
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * LoadBalanced的具体知识请看LoadBalancerClient.class
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
