package com.xqk.cloud.eureka.client.controller;

import com.netflix.discovery.EurekaClient;
import com.xqk.cloud.eureka.client.config.ServiceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author 熊乾坤
 */
@RefreshScope
@RestController
@Slf4j
public class HelloWorldController {
    private final EurekaClient eurekaClient;

    private Random random=new Random();

    private final ServiceConfig config;

    /**
     * 可以通过DiscoveryClient来获取服务端的元数据
     */
    private final DiscoveryClient discoveryClient;

    @Autowired
    public HelloWorldController(@Qualifier("eurekaClient") EurekaClient eurekaClient, ServiceConfig config, DiscoveryClient discoveryClient) {
        this.eurekaClient = eurekaClient;
        this.config = config;
        this.discoveryClient = discoveryClient;
    }


    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/delay")
    public String hasDelay() throws InterruptedException {
        int delay=random.nextInt(3500);
        Thread.sleep(delay);
        log.info("故意睡着了"+delay+"毫秒");
        return "想不到吧，我没迟到。";
    }

    @GetMapping("/bye")
    public String say() {
        return "bye";
    }

    @GetMapping(value = "/config")
    public String config(){
        return config.toString();
    }

    /**
     * 获取指定serviceID的元数据
     * @param serviceId 服务器名
     * @return 元数据信息
     */
    @GetMapping("/metadata/{serviceId}")
    public List<ServiceInstance> metadata(@PathVariable String serviceId){
        return discoveryClient.getInstances(serviceId);
    }

    /**
     * 获取所有已注册的服务的serviceID
     * @return serviceID列表
     */
    @GetMapping("/instance")
    public List<String> in(){
        return discoveryClient.getServices();
    }
}