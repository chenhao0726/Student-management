package com.chen.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        // 1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 2.获取请求资源路径
        String requestURI = request.getRequestURI();
        // 3.判断是否包含登录相关资源路径，同时排除css，js，图片等
        if (requestURI.contains("/login.jsp") || requestURI.contains("/login") ||
                requestURI.contains("/img/") || requestURI.contains("/scripts/") ||
                requestURI.contains("/styles/")) {
            // 放行
            filterChain.doFilter(req,resp);
        } else {
            // 4.判断是否登录
            Object username = request.getSession().getAttribute("username");
            System.out.println("===========username" + username);
            if (username != null) {
                // 已经登录，放行
                filterChain.doFilter(req,resp);
            } else {
                // 未登录
                request.setAttribute("login_msg","你还未登录");
//                response.sendRedirect("/login.jsp");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
