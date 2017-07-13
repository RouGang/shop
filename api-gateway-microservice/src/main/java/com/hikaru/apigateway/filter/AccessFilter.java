package com.hikaru.apigateway.filter;

import com.google.common.base.Strings;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hikaru on 17/6/8.
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
     * 我们直接返回true，所以该过滤器总是生效。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //过滤白名单
        if (!request.getRequestURI().contains("/feign/test/login")){
            String auth = request.getHeader("Authorization");
            if (Strings.isNullOrEmpty(auth)){
                setResponse(ctx,403,"Token Is Empty.");
                return null;
            }

            String token = auth.replaceAll("Bearer","").trim();
            if (Strings.isNullOrEmpty(token)){
                setResponse(ctx,403,"Token Is Empty.");
                return null;
            }

            //校验token
           // JWTVerifier verifier = new JWTVerifier("57e3ee14b1684858861963212cab40b8");
            try {
                Map<String, Object> claim = new HashMap<String, Object>();
                        //verifier.verify(token);
                //验证通过
                logger.info(String.format("%s请求%s接口(Token Valid Success).",
                        claim.get("un").toString(),
                        request.getRequestURI()));
                return null;
            } catch (Exception e) {
                logger.error(e.getMessage());
                setResponse(ctx,403,"Invalid Token.");
            }
        }
        return null;
    }

    /**
     * 设置Response
     * @param ctx
     * @param statusCode
     * @param body
     */
    private void setResponse(RequestContext ctx, int statusCode, String body){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(statusCode);
        if (!Strings.isNullOrEmpty(body)){
          //  ctx.setResponseBody(AKResult.builder().fail().errMsg(body).build());
        }
    }
}
