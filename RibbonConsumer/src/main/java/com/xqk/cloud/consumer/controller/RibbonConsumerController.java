package com.xqk.cloud.consumer.controller;

import com.xqk.cloud.consumer.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 熊乾坤
 */
@RestController
@Slf4j
public class RibbonConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/hello")
    public String sayHello(){
        String msg=restTemplate.getForObject("http://MICROSERVICE-EUREKACLIENT/hello",String.class);
        log.info("request microService-client for return "+msg);
        return msg;
    }

    @GetMapping("/instance")
    public List getInstance(){
        List msg=restTemplate.getForObject("http://MICROSERVICE-EUREKACLIENT/instance", List.class);
        log.info("request microService-client for return "+msg);
        return msg;
    }

    /**
     * 检测负载均衡的策略，默认为轮询的方式
     * @return instanceId
     */
    @GetMapping("/loaBalance-info")
    public String getLoadBalanceInfo(){
        ServiceInstance serviceInstance=loadBalancerClient.choose("MICROSERVICE-EUREKACLIENT");
        return serviceInstance.getInstanceId();
    }

    /**
     * 熔断的测试方法。
     * @return string
     */
    @GetMapping("/call-delay")
    public String sayHelloWithBreaker(){
        return hystrixService.callDelay();
    }
}
