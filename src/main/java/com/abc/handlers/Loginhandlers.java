package com.abc.handlers;

import com.abc.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/Login")
public class Loginhandlers {
    @Autowired
    private ILoginService ILoginservice;
    @RequestMapping("/login.do")
    public  void login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        String id = req.getParameter("username");
        String password = req.getParameter("password");
        String Role = req.getParameter("select");
        String pd=null;
        String address=null;
        if(Role.equals("1")){
            pd = ILoginservice.findmpassword(id);
            address="/page/manager.jsp";
            session.setAttribute("mid",id);
        }else if(Role.equals("2")){
            pd = ILoginservice.findtpassword(id);
            address="/teacher/teacher.jsp";
            session.setAttribute("tid",id);
        }else if(Role.equals("3")){
            pd = ILoginservice.findspassword(id);
            address="/student/student.jsp";
            session.setAttribute("id",id);
        }else{
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp?error=true").forward(req,resp);
        }
        if(password.equals(pd)){
            session.setAttribute("user_session",id);
            req.getRequestDispatcher(req.getContextPath()+address).forward(req,resp);
        }
        else  {
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp?error=yes").forward(req,resp);
        }
    }

}
