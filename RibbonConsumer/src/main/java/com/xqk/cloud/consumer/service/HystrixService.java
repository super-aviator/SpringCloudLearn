package com.xqk.cloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 熊乾坤
 */
@Component
@Slf4j
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 实例的/delay接口可能会延迟，排除掉网络延时，有一半的几率会触发熔断
     *
     * @return 实例返回的结果
     */
    @HystrixCommand(fallbackMethod = "delayFallback")
    public String callDelay() {
        long beginTime = System.currentTimeMillis();
        String result=restTemplate.getForObject("http://MICROSERVICE-EUREKACLIENT/delay", String.class);
        long elapseTime=System.currentTimeMillis()-beginTime;
        log.info("调用/delay接口耗时："+elapseTime);
        return result;
    }

    @SuppressWarnings("unused")
    private String delayFallback() {
        return "对不起，链接超时了。。。";
    }
}