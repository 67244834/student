package com.abc.handlers;

import com.abc.beans.*;
import com.abc.service.ILoginServiceImpl;
import com.abc.service.pickServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher/pick")
public class pickhandlers {
    @Autowired
    private pickServiceImpl service;
    @Autowired private ILoginServiceImpl login;
    @RequestMapping("/showAllCourse.do")
    public String showCourse(@RequestParam(defaultValue = "1") int pageno, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Course> page = new Page<Course>();
        page = service.findAllCourse(pageno);
        req.setAttribute("course",page);
        return "/teacher/teacherpick.jsp";
    }
    @RequestMapping("/showpickCourse.do")
    public void showpickCourse(@RequestParam(defaultValue = "1") int pageno, HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) session.getAttribute("tid");
        Page<Course> page = new Page<>();
        page = service.findpickCourse(id,pageno);
        req.setAttribute("tpick",page);
        req.getRequestDispatcher(req.getContextPath()+"/teacher/tshowpick.jsp").forward(req,resp);
    }
    @RequestMapping("/tpickCourse.do")
    public void tpickCourse(HttpServletRequest req,HttpSession session) {
        String cid = req.getParameter("cid");
        String id = (String) session.getAttribute("tid");
        service.modifypick(cid, id);
    }
    @ResponseBody
    @RequestMapping("/ttpickCourse.do")//退选
    public String ttpickCourse(@RequestBody Map<String,Object> json){
       String cid = (String) json.get("cid");
            service.modifypick2(cid);
            return "1";
    }
    @RequestMapping("/showStudent.do")
    public String showStudent(@RequestParam(defaultValue = "1") int pageno, HttpSession session, HttpServletRequest req) throws ServletException, IOException {
        String id = (String) session.getAttribute("tid");
        Page<Teacher> page = new Page<>();
        page = service.findStudent(id,pageno);
        req.setAttribute("score",page);
        return "/teacher/showStudent.jsp";
    }
    @RequestMapping("/upScore.do")
    public void upScore(HttpServletRequest req, HttpServletResponse resp, Sc sc) throws ServletException, IOException {
        try {
            service.modifyScore(sc);
            req.getRequestDispatcher(req.getContextPath() + "/teacher/pick/showStudent.do").forward(req, resp);
        }catch (Exception e){
            resp.getWriter().println("<script language='javascript'>alert('输入格式错误，请检查后重新添加!');window.history.back(-1);</script>");
        }
    }
    @RequestMapping("/showtUser.do")
    public void showtuser(HttpServletRequest req,HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
        String id = (String)session.getAttribute("tid");
        Teacher teacher = service.findTeacher(id);
        session.setAttribute("teacher",teacher);
        req.getRequestDispatcher(req.getContextPath() + "/teacher/showTeacher.jsp").forward(req, resp);
    }
    @RequestMapping("/upTeacher.do")
    public void upTeacher(HttpServletRequest req,HttpServletResponse resp,Teacher teacher) throws ServletException, IOException {
        try {
            service.modifyTeacher(teacher);
            req.getRequestDispatcher(req.getContextPath() + "/teacher/pick/showtUser.do" ).forward(req, resp);
        }catch (Exception e){
            resp.getWriter().println("<script language='javascript'>alert('输入格式错误，请检查后重新添加!');window.history.back(-1);</script>");
        }
    }
    @RequestMapping("/uptpassword.do")
    public void uppassword(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String tid = req.getParameter("id");
        String mpass = req.getParameter("mpass");
        String newpass = req.getParameter("newpass");
        String renewpass = req.getParameter("renewpass");
        String password = login.findtpassword(tid);
        if(password.equals(mpass)){
            if(newpass.equals(renewpass)){
                service.midifytpassword(newpass,tid);
                resp.getWriter().println("<script language='javascript'>alert('修改密码成功，请重新登录！！');window.top.location.href = '/login.jsp';</script>");
            }else{
                resp.getWriter().println("<script language='javascript'>alert('两次密码输入不一致，请重新输入！！');window.history.back(-1);</script>");
            }
        }else{
            resp.getWriter().println("<script language='javascript'>alert('原始密码错误！！');window.history.back(-1);</script>");
        }
    }
}
