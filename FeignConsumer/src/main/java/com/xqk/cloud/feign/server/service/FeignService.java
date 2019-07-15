package com.xqk.cloud.feign.server.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 熊乾坤
 * 被@FeignClient注解的类不需要使用@Component注解，需要的地方直接注入即可
 */
@FeignClient(
        name = "microservice-eurekaclient"
)
public interface FeignService {
    @GetMapping("/delay")
    String callDelay();
}
