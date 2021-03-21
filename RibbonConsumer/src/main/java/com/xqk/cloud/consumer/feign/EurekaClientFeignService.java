package com.xqk.cloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * feign也支持继承,可以从基类的接口中继承方法
 *
 * @author 熊乾坤
 * @date 2019/10/3 19:26
 */
@FeignClient(name = "MICROSERVICE-EUREKACLIENT1")
public interface EurekaClientFeignService extends BaseFeignService{

    /**
     * 获取所有已注册的服务的serviceID
     *
     * @return serviceID列表
     */
    @GetMapping("/instance")
    List<String> getInstanceID();
}
