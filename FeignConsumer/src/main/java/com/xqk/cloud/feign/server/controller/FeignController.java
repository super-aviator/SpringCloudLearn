package com.xqk.cloud.feign.server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xqk.cloud.feign.server.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 熊乾坤
 */
@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/delay")
    @HystrixCommand(fallbackMethod="callDelayCallback")
    public String callDelay(){
        return feignService.callDelay();
    }

    public String callDelayCallback(){
        return "对不起，熔断触发了";
    }
}
