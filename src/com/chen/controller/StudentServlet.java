package com.chen.controller;

import com.chen.domain.Grade;
import com.chen.domain.Student;
import com.chen.service.IGradeService;
import com.chen.service.IStudentService;
import com.chen.service.impl.GradeServiceImpl;
import com.chen.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
    private IStudentService service = new StudentServiceImpl();
    private IGradeService iGradeService = new GradeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        System.out.println("=========" + type + "============");
        switch (type) {
            case "list":
                List<Student> stuList = service.queryAll();
                req.getSession().setAttribute("stuList",stuList);
                // 请求转发
                req.getRequestDispatcher("/WEB-INF/views/stu/stuinfor.jsp").forward(req,resp);
                break;
            case "save":
                save(req,resp);
                break;
            case "input":
                input(req,resp);
                break;
            case "delete":
                // 接收id
                String id = req.getParameter("id");
                int i = service.deleteById(Long.parseLong(id));
                System.out.println("====delete====>" + i);
                // 重定向到infor
                resp.sendRedirect("/stu?type=list");
                break;
            case "out":
                req.getSession().removeAttribute("username");
                // 跳转页面 重定向
                resp.sendRedirect("/login.jsp");
                break;
            case "classInput":
                String className = req.getParameter("className");
                Grade grade = new Grade(className);
                int i1 = iGradeService.saveClass(grade);
                System.out.println("====class====>" + i1);
                // 重定向到infor
                resp.sendRedirect("/stu?type=list");
        }
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收参数
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String time = req.getParameter("time");
        String class_id = req.getParameter("class_id");
//        System.out.println(id +"=="+name+"=="+password+"=="+age+"=="+gender+"=="+phone+"=="+address+"=="+class_id);
        // 判断id是否存在
        if (!"".equals(id) && id != null) {
            Student student = new Student(Long.parseLong(id), name, password, Integer.parseInt(age),
                    Integer.parseInt(gender), phone, address, Long.parseLong(class_id));
            int update = service.update(student);
            req.getSession().setAttribute("msg",update);
        } else {
            Student student = new Student(name, password, Integer.parseInt(age),
                    Integer.parseInt(gender), phone, address, Long.parseLong(class_id));
            System.out.println(student);
            int save = service.save(student);
            req.getSession().setAttribute("msg",save);
        }
        resp.sendRedirect("/stu?type=list");
    }

    public void input(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收参数id
        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        if (!"".equals(id) && id != null) {
            Student student = service.selectById(Long.parseLong(id));
            session.setAttribute("student",student);
        }
        List<Grade> grades = iGradeService.selectAll();
        session.setAttribute("grades",grades);
        Enumeration<String> e = session.getAttributeNames();
        while(e.hasMoreElements()){
            String sessionName=(String)e.nextElement();
            System.out.println("存在的session有："+sessionName);
        }
        req.getRequestDispatcher("/WEB-INF/views/stu/stusave.jsp").forward(req,resp);
        session.removeAttribute("student");
    }
}
