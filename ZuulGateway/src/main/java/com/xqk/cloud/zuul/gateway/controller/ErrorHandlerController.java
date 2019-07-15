package com.xqk.cloud.zuul.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 熊乾坤
 */
@Controller
@Slf4j
public class ErrorHandlerController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<String> error(HttpServletRequest request) {
        log.info(request.getParameterMap().toString());
        return new ResponseEntity<>("网关抛出异常啦",HttpStatus.BAD_GATEWAY);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
