package com.mohsinkd786.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class ZuulPreFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(ZuulPreFilter.class);

    @Value("${zuul.filter.pre.enabled}")
    private boolean isEnabled;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return isEnabled;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("Zuul Pre Filter...");
        return null;
    }
}
