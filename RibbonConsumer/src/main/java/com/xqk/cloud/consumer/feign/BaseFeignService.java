package com.xqk.cloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 熊乾坤
 * @date 2019/10/3 21:54
 */
public interface BaseFeignService {
    @GetMapping("/hello")
    String sayHello();
}
