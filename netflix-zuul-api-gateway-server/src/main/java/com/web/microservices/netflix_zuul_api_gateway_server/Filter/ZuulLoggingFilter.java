package com.web.microservices.netflix_zuul_api_gateway_server.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";//post/error
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        javax.servlet.http.HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("request -> {} request uri -> {}", request,request.getRequestURI());
        return null;
    }
}
