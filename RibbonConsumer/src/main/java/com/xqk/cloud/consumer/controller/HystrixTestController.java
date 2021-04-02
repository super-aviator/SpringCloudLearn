package com.xqk.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xqk.cloud.consumer.feign.HystrixTestFeignClient;
import com.xqk.cloud.consumer.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日期 2019/10/14 11:12
 *
 * @author 熊乾坤
 */
@RestController
@Slf4j
public class HystrixTestController {
    private final HystrixTestFeignClient hystrixTestFeignClient;
    private final HystrixService hystrixService;

    public HystrixTestController(HystrixTestFeignClient hystrixTestFeignClient, HystrixService hystrixService) {
        this.hystrixTestFeignClient = hystrixTestFeignClient;
        this.hystrixService = hystrixService;
    }

    @GetMapping("/feign/{milli}")
    @HystrixCommand(fallbackMethod = "fallBackMethod")
    public String callDelayInterface(@PathVariable long milli) {
        return hystrixTestFeignClient.callDelayInterface(milli);
    }

    /**
     * 熔断的测试方法。
     *
     * @return string
     */
    @GetMapping("/delay/{milliSeconds}")
    public String delayWithMilliSeconds(@PathVariable("milliSeconds") Long milliSeconds) {
        return hystrixService.callDelay(milliSeconds);
    }

    /**
     * 熔断的测试方法。
     *
     * @return string
     */
    @GetMapping("/delayWithRandom")
    public String delayWithRandomMilliSeconds() {
        return hystrixService.callRandomDelay();
    }

    public String fallBackMethod(long milli, Throwable e) {
        log.error("熔断异常", e);
        return "调用接口，延时" + milli + "毫秒，失败了";
    }
}
