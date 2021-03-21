package com.xqk.cloud.zuul.gateway.bean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 编写最基本的过滤器,打印网关接收到的请求信息
 * 日期 2019/10/10 14:22
 *
 * @author 熊乾坤
 */
@Component
@Slf4j
public class PrePrintRequestInfoFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest hsr = ctx.getRequest();
        log.info("zuul received request uri: {} method: {}", hsr.getRequestURI(), hsr.getMethod());
        return null;
    }
}
