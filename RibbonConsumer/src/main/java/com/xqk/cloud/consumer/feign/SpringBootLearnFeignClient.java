package com.xqk.cloud.consumer.feign;

import com.xqk.cloud.consumer.dto.UserProjectionDTO;
import com.xqk.cloud.consumer.feign.fallback.SpringBootLearnFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;

/**
 * FeignClient注解的name属性不区分大小写
 *
 * @author 熊乾坤
 * @date 2019/10/4 8:21
 */
@FeignClient(name = "MICROSERVICE-SPRINGBOOTLEARN", fallback = SpringBootLearnFeignClientFallback.class)
public interface SpringBootLearnFeignClient {

    @GetMapping("/basic/hello")
    String hello();

    @GetMapping("/basic/delayWithRandom")
    String delayWithRandom();

    @GetMapping("/basic/delayWithParam/{milliSeconds}")
    String delayWithParam(@PathVariable Long milliSeconds);

    @GetMapping("user/all")
    List getAllUser();

    @PostMapping("user/add")
    String addUser(@RequestBody UserProjectionDTO userProjectionDTO);
}
