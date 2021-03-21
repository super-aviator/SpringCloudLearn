package com.xqk.cloud.zuul.gateway.bean.filter;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;



/**
 * 抛出异常的过滤器
 *
 * @author 熊乾坤
 */

@Component
@Slf4j
public class PreErrorGenericFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10000;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        log.info("ErrorGenericFilter 抛出了一个异常");
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            //throw new ZuulException(e,"网关抛出了异常",1,"");
            return null;
        }
    }
}
