package com.xqk.cloud.consumer.feign.fallback;

import com.xqk.cloud.consumer.dto.UserProjectionDTO;
import com.xqk.cloud.consumer.feign.SpringBootLearnFeignClient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 服务降级必须要加@Component注解，否则服务会无法启动
 * 服务降级属于Hystrix模块的功能，故需要开启配置feign.hystrix.enabled=true
 *
 * @author 熊乾坤
 * @since 2021-03-23 22:10
 */
@Component
public class SpringBootLearnFeignClientFallback implements SpringBootLearnFeignClient {
    @Override
    public String hello() {
        return "连接超时";
    }

    @Override
    public String delayWithRandom() {
        return "连接超时";
    }

    @Override
    public String delayWithParam(Long milliSeconds) {
        return "连接超时";
    }

    @Override
    public List getAllUser() {
        return Collections.emptyList();
    }

    @Override
    public String addUser(UserProjectionDTO userProjectionDTO) {
        return "连接超时";
    }
}
