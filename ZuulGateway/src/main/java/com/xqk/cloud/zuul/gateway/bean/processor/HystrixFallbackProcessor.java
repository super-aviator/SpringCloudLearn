package com.xqk.cloud.zuul.gateway.bean.processor;

import org.apache.commons.io.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author 熊乾坤
 * <p>
 * 熔断时,会调用FilbackProvider的实现类
 */
@Component
@Slf4j
public class HystrixFallbackProcessor implements FallbackProvider {
    @Override
    public String getRoute() {
        return "microservice-eurekaclient";
    }


    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() {
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                return IOUtils.toInputStream("熔断发生了", Charset.forName("utf-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                //自定义头部
                headers.set("name", "xqk");
                headers.set("Content-Type", "text/plain;charset=UTF-8");
                return headers;
            }
        };
    }
}
