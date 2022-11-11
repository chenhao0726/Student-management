package com.chen.controller;

import com.chen.domain.User;
import com.chen.service.IUserService;
import com.chen.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        User user = service.selectByName(username);
        // 判断登录
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            // 把user放入session
//            session.setAttribute("user",user);
            // 把username放入session
            session.setAttribute("username",user.getUsername());
            // 跳转页面 重定向
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
//            resp.sendRedirect("/stu?type=list");
        } else {
            req.setAttribute("msg","账号密码错误！");
            // 跳转页面 请求转发
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
