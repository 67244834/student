package com.abc.handlers;

import com.abc.beans.Page;
import com.abc.beans.Teacher;
import com.abc.service.ITeacherManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
@Controller
@RequestMapping("/Teacher")
public class TeacherManagerHanders {
    @Autowired
    private ITeacherManagerService iTeacherManagerService;
    @RequestMapping("/queryTeacher.do")
    public String queryTeacher(String id,String a, @RequestParam(defaultValue = "1")int pageno , Model model){
        if("-1".equals(id)){  //查询全部
            String arr = "请选择查询方式";
            Page<Teacher> page = iTeacherManagerService.findTeachermessage(pageno);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            model.addAttribute("arr",arr);
            return "/page/teacherMessage.jsp";
        }
        if("1".equals(id)){  //精确查询
            Page<Teacher> page = iTeacherManagerService.findTeachermessage1(pageno,a);
            String arr = "精确查询";
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            model.addAttribute("arr",arr);
            return "/page/teacherMessage.jsp";
        }
        if("2".equals(id)){ //模糊查询
            Page<Teacher> page = iTeacherManagerService.findTeachermessage2(pageno,a);
            String arr = "模糊查询";
            model.addAttribute("arr",arr);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            return "/page/teacherMessage.jsp";
        }
        return null;
    }
    @RequestMapping("/delTeacher.do")//删除老师信息
    public String delTeacherServlet(String tid) {
        iTeacherManagerService.removeTeacherById(tid);
        return "/Teacher/queryTeacher.do?id=-1";
    }
    @RequestMapping("/delAllTeacher.do")//删除全部老师信息
    public String delAllTeacher(String tid) {
        String id[]=tid.split(",");
        for(int i=0;i<id.length;i++){
            iTeacherManagerService.removeTeacherById(id[i]);
        }
        return "/Teacher/queryTeacher.do?id=-1";
    }

    @RequestMapping("/addTeacher.do")//添加老师信息
    public void addTeacher (Teacher teacher,HttpServletResponse response) throws Exception {
        System.out.println(teacher);
        String password = "123456";
        teacher.setPassword(password);
        String tid= teacher.getTid();
        Teacher teacher1 = iTeacherManagerService.findTeacherById(tid);
        if (teacher1!=null) {
            response.getWriter().println("<script language='javascript'>alert('学号重复，请重新检查后重新添加！');window.history.back(-1);</script>");
        }
        else {
            iTeacherManagerService.saveTeacher(teacher);
            response.getWriter().println("<script language='javascript'>alert('添加成功！');location.href='/Teacher/queryTeacher.do?id=-1';</script>");
        }
    }
    @RequestMapping("/selectTeacher.do")//查看老师信息
    public String selectTeacher(String id,String i,Model model) {
        Teacher teacher = iTeacherManagerService.findTeacherById(id);
        model.addAttribute("teacher",teacher);
        if (i.equals("0")) {
            return "/page/updateTeacher.jsp";
        }
        if(i.equals("1")){
            return "/page/showTeacherMessage.jsp";
        }
        return null;
    }
    @RequestMapping("/updateTeacher.do")//修改个人信息
    public String updateTeacher(Teacher teacher)  {
        iTeacherManagerService.modifyTeacher(teacher);
        return "/Teacher/queryTeacher.do?id=-1";
    }
}
