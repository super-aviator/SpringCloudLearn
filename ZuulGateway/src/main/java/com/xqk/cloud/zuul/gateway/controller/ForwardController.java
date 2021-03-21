package com.xqk.cloud.zuul.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试forward属性,当配置了zuul内部跳转时,需要指定zuul项目的本地地址
 *
 * @author 熊乾坤
 * @date 2019/10/7 0:30
 */
@RestController
@RequestMapping("/forward-path")
public class ForwardController {
    @GetMapping("/msg")
    public String getForwardMsg() {
        return "you has request forward path";
    }
}
