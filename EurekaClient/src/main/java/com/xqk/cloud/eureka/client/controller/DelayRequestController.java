package com.xqk.cloud.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟服务处理慢而导致请求慢的情况
 * 日期 2019/10/14 10:41
 *
 * @author 熊乾坤
 */
@RestController
@RequestMapping("/delayInMilli")
@Slf4j
public class DelayRequestController {
    @GetMapping("/{milli}")
    public String delayTime(@PathVariable long milli) throws InterruptedException {
        Thread.sleep(milli);
        log.info("延迟了{}毫秒",milli);
        return "延迟了"+milli+"毫秒之后，成功返回了";
    }
}
