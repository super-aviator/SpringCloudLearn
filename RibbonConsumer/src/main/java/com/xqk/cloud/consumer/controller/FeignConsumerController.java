package com.xqk.cloud.consumer.controller;

import com.xqk.cloud.consumer.dto.UserProjectionDTO;
import com.xqk.cloud.consumer.feign.EurekaClientFeignService;
import com.xqk.cloud.consumer.feign.SpringBootLearnFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 熊乾坤
 * @date 2019/10/3 19:25
 */

@RestController
@RequestMapping("/feign")
public class FeignConsumerController {
    private final EurekaClientFeignService eurekaClientFeignService;
    private final SpringBootLearnFeignClient springBootLearnFeignClient;

    @Autowired
    public FeignConsumerController(EurekaClientFeignService eurekaClientFeignService,
                                   SpringBootLearnFeignClient springBootLearnFeignClient) {
        this.eurekaClientFeignService = eurekaClientFeignService;
        this.springBootLearnFeignClient = springBootLearnFeignClient;
    }

    @GetMapping("/instance")
    public List<String> callFeign() {
        return eurekaClientFeignService.getInstanceID();
    }


    @GetMapping("/hello")
    public String hello() {
        return springBootLearnFeignClient.hello();
    }

    @GetMapping("/delayWithRandom")
    String delayWithRandom() {
        return springBootLearnFeignClient.delayWithRandom();
    }

    @GetMapping("/delayWithParam/{milliSeconds}")
    String delayWithParam(@PathVariable Long milliSeconds) {
        return springBootLearnFeignClient.delayWithParam(milliSeconds);
    }

    @GetMapping("/user/all")
    public List getAllUsers() {
        return springBootLearnFeignClient.getAllUser();
    }

    @PostMapping("/user/add")
    public void addUser(@RequestBody UserProjectionDTO userProjectionDTO) {
        springBootLearnFeignClient.addUser(userProjectionDTO);
    }
}