package com.xqk.cloud.consumer.feign;

import com.xqk.cloud.consumer.dto.UserProjectionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 熊乾坤
 * @date 2019/10/4 8:21
 */
@FeignClient(name = "MICROSERVICE-SPRINGBOOTLEARN")
public interface SpringBootLearnFeignService {

    @GetMapping("user/all")
    List getAllUser();

    @PostMapping("user/add")
    String addUser(@RequestBody UserProjectionDTO userProjectionDTO);
}
