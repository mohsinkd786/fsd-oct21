package com.mohsinkd786.filters;

import com.mohsinkd786.services.SecurityService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;


public class ZuulRouteFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(ZuulRouteFilter.class);

    @Value("${zuul.filter.route.enabled}")
    private boolean isEnabled;

    private SecurityService securityService;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
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
        log.info("Zuul Route Filter...");
        RequestContext context = RequestContext.getCurrentContext();
        // validate the received credentials
        authenticate(context);
        return null;
    }
    private boolean authenticate(RequestContext context) throws ZuulException{

        // get headers from the request
        // access authorization header
        String authorization = context.getRequest().getHeader("Authorization");
        boolean isAuthenticated =securityService.authenticate(authorization);
        if(!isAuthenticated){
            context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            context.setResponseBody("{\n" +
                    "\t\"message\": \"Invalid credentials specified\",\n" +
                    "\t\"errorCode\":" + HttpStatus.FORBIDDEN.value() + "}");
            context.setSendZuulResponse(false);
            context.addZuulResponseHeader("Content-Type", "application/json");
            return false;
        }else{
            context.addZuulResponseHeader("authorized", "true");
            context.addZuulRequestHeader("message","Welcome Zuul Proxy");
         return true;
        }
    }
}
