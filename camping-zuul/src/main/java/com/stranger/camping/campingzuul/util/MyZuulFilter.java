package com.stranger.camping.campingzuul.util;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//zuul不仅只是路由，并且还能过滤，做一些安全验证。没有登录的拦截，可以配合jwt使用单点登陆
@Component
public class MyZuulFilter extends ZuulFilter {
    //filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
//        pre：路由之前
//        routing：路由之时
//        post： 路由之后
//        error：发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

//    filterOrder：过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }
//    shouldFilter：这里可以写逻辑判断，是否要过滤，true,永远过滤。
//    @Override
    public boolean shouldFilter() {
        return true;
    }
//  run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
//    说白了就是查看页面客户端是否有token，即登录信息，有就放行，否则做拦截告知token is empty，实际业务可让其跳转登录页面
    @Override
    public Object run() throws ZuulException {
        System.out.println("hello, world");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取请求链接
        String requestURI = request.getRequestURI();
        //得到token对象
        Object accessToken = request.getParameter("token");
        //判断链接是都要放行
        if(requestURI.equals("/api-b/user/findName") ||requestURI.equals("/api-b/user/createImg")){
            return null;
        }

        if(accessToken == null) {
            ctx.setSendZuulResponse(false); // 设置原来的响应无效
            ctx.setResponseStatusCode(401); // 改变状态码为401
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }



        return null;
    }
}
