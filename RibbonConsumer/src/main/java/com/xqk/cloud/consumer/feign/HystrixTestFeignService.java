package com.xqk.cloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 使用Feign测试熔断是否能够正常工作
 * 日期 2019/10/14 11:05
 *
 * @author 熊乾坤
 */
@FeignClient(name = "MICROSERVICE-EUREKACLIENT")
public interface HystrixTestFeignService {
    @GetMapping("/delayInMilli/{milli}")
    String callDelayInterface(@PathVariable long milli);
}
