package com.tzh.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name="encoding",value="utf-8"),
                @WebInitParam(name = "textType",value = "text/html;charset=utf-8")})
public class EncodingFilter implements Filter {
    private  FilterConfig filterConfig = null;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        // 过滤静态页面
        String URI = req.getRequestURI() ;
        //    排除静态页面
        if (URI.contains(".css") || URI.contains(".js") || URI.contains(".png")) {
            chain.doFilter(req, resp);
            return ;
        }
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }
}
