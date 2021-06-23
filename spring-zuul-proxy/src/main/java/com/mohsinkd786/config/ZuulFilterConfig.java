package com.mohsinkd786.config;

import com.mohsinkd786.filters.ZuulErrorFilter;
import com.mohsinkd786.filters.ZuulPostFilter;
import com.mohsinkd786.filters.ZuulPreFilter;
import com.mohsinkd786.filters.ZuulRouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public ZuulErrorFilter zuulErrorFilter(){
        return new ZuulErrorFilter();
    }

    @Bean
    public ZuulPreFilter preFilter(){
        return new ZuulPreFilter();
    }

    @Bean
    public ZuulPostFilter postFilter(){
        return new ZuulPostFilter();
    }

    @Bean
    public ZuulRouteFilter routeFilter(){
        return new ZuulRouteFilter();
    }
}
