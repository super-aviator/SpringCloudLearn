package com.xqk.cloud.zuul.gateway.bean.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * @author 熊乾坤
 */
@Component
public class PreSecurityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤顺序对于不同阶段是相互独立的，
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response=ctx.getResponse();
        response.setContentType("text/html:charset=UTF-8");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        if (request.getParameter("token") == null) {
            //设置不对该请求进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            ctx.setResponseBody("token都没有？你是什么垃圾？");
        }
        return null;
    }
}
