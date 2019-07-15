package com.xqk.cloud.zuul.gateway.bean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 熊乾坤
 */
@Component
@Slf4j
public class PostHandlerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletResponse httpServletResponse=context.getResponse();
        log.info("*****POST过滤器执行了 ");
        httpServletResponse.setHeader("Content-Type","text/html:charset=UTF-8");
        httpServletResponse.setHeader("name","熊乾坤");
        return null;
    }
}
