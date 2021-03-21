package com.xqk.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xqk.cloud.consumer.feign.HystrixTestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 日期 2019/10/14 11:12
 *
 * @author 熊乾坤
 */
@RestController
@RequestMapping("/delay")
@Slf4j
public class HystrixTestController {
    private final HystrixTestFeignService hystrixTestFeignService;

    public HystrixTestController(HystrixTestFeignService hystrixTestFeignService) {
        this.hystrixTestFeignService = hystrixTestFeignService;
    }

    @GetMapping("/{milli}")
    @HystrixCommand(fallbackMethod = "fallBackMethod")
    public String callDelayInterface(@PathVariable long milli){
        return hystrixTestFeignService.callDelayInterface(milli);
    }

    public String fallBackMethod(long milli,Throwable e){
        log.error("熔断异常",e);
        return "调用接口，延时"+milli+"毫秒，失败了";
    }
}
