package xws.microservice.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import xws.microservice.zuul.client.UserClient;

import javax.servlet.http.HttpServletRequest;

public class AuthFilter extends ZuulFilter {
    private final String HEADER = "x-auth";
    private final String PREFIX = "Bearer ";

    @Autowired
    private UserClient userClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)){
            System.out.println( "No header present");
            return null;
        }

        String jwtToken = authenticationHeader.replace(PREFIX, "");
        System.out.println(jwtToken);

        try {
            boolean valid = userClient.verify(jwtToken);
            System.out.println(valid);
            // redirection (?) -> not needed I fixed it... :) -> FUCK YEAH!
        } catch (Exception e) {
            setFailedRequest("Invalid token", 403);
        }

        return null;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

}
