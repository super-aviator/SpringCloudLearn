package com.xqk.cloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 带熔断功能的service方法
 *
 * @author 熊乾坤
 * @since 2021年3月22日18:50:52
 */
@Component
@Slf4j
public class HystrixService {

    private final RestTemplate restTemplate;

    public HystrixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 实例的/delayWithRandom接口可能会延迟，排除掉网络延时，
     *
     * @return 实例返回的结果
     */
    @HystrixCommand(fallbackMethod = "delayFallback")
    public String callDelay(Long milliseconds) {
        long beginTime = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://MICROSERVICE-SPRINGBOOTLEARN/basic/delayWithParam/" + milliseconds, String.class);
        long elapseTime = System.currentTimeMillis() - beginTime;
        log.info("调用/delay接口耗时：" + elapseTime);
        return result;
    }

    /**
     * 实例的/delayWithRandom方法延迟时间是随机的从0~60秒
     *
     * @return 实例的返回结果
     */
    @HystrixCommand(fallbackMethod = "delayFallback")
    public String callRandomDelay() {
        long beginTime = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://MICROSERVICE-SPRINGBOOTLEARN/basic/delayWithRandom", String.class);
        long elapseTime = System.currentTimeMillis() - beginTime;
        log.info("调用/delay接口耗时：" + elapseTime);
        return result;
    }

    @SuppressWarnings("unused")
    private String delayFallback(Long milliseconds) {
        return "对不起，链接超时了。。。";
    }

    @SuppressWarnings("unused")
    private String delayFallback() {
        return "对不起，链接超时了。。。";
    }
}