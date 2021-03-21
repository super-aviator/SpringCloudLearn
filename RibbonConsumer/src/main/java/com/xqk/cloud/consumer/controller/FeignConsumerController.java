package com.xqk.cloud.consumer.controller;

import com.xqk.cloud.consumer.dto.UserProjectionDTO;
import com.xqk.cloud.consumer.feign.EurekaClientFeignService;
import com.xqk.cloud.consumer.feign.SpringBootLearnFeignService;
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
    private final SpringBootLearnFeignService springBootLearnFeignService;

    @Autowired
    public FeignConsumerController(EurekaClientFeignService eurekaClientFeignService, SpringBootLearnFeignService springBootLearnFeignService) {
        this.eurekaClientFeignService = eurekaClientFeignService;
        this.springBootLearnFeignService = springBootLearnFeignService;
    }

    @GetMapping("/instance")
    public List<String> callFeign() {
        return eurekaClientFeignService.getInstanceID();
    }


    @GetMapping("/hello")
    public String hello() {
        return eurekaClientFeignService.sayHello();
    }

    @GetMapping("/user/all")
    public List getAllUsers() {
        return springBootLearnFeignService.getAllUser();
    }

    @PostMapping("/user/add")
    public void addUser(@RequestBody UserProjectionDTO userProjectionDTO) {
        springBootLearnFeignService.addUser(userProjectionDTO);
    }
}