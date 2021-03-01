package com.abc.handlers;

import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.service.IStudentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller

@RequestMapping("/Student")
public class StudentManagerHanders {
    @Autowired
    private IStudentManagerService iStudentManagerService;

    @RequestMapping("/queryStudent.do")
    public String queryStudent(String id,String a, @RequestParam(defaultValue = "1")int pageno , Model model){
        if("-1".equals(id)){  //查询全部
            Page<Student> page = iStudentManagerService.findStudentmessage(pageno);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "请选择查询方式";
            model.addAttribute("arr",arr);
            return "/page/studentMessage.jsp";
        }
        if("1".equals(id)){  //精确查询
            Page<Student> page = iStudentManagerService.findStudentmessage1(pageno,a);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "精确查询";
            model.addAttribute("arr",arr);
            return "/page/studentMessage.jsp";
        }
        if("2".equals(id)){ //模糊查询
            Page<Student> page = iStudentManagerService.findStudentmessage2(pageno,a);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "模糊查询";
            model.addAttribute("arr",arr);
            return "/page/studentMessage.jsp";
        }
        return null;
    }

    @RequestMapping("/delStudent.do")//删除个人信息
    public String delStudent(String sid) {
        iStudentManagerService.removeStudentById(sid);
        return "/Student/queryStudent.do?id=-1";
    }

    @RequestMapping("/delAllStudent.do")//删除全部个人信息
    public String delAllStudent(String sid){
        String id[]=sid.split(",");

        for(int i=0;i<id.length;i++){
            iStudentManagerService.removeStudentById(id[i]);
        }
        return "/Student/queryStudent.do?id=-1";
    }

    @RequestMapping("/addStudent.do")//添加学生信息
    public void addStudent (Student student, HttpServletResponse response) throws Exception {
        String sid = student.getSid();
        String password = "123456";
        student.setPassword(password);
        Student student1 = iStudentManagerService.findStudentById(sid);
        if (student1!=null) {
            response.getWriter().println("<script language='javascript'>alert('学号重复，请重新检查后重新添加！');window.history.back(-1);</script>");
        }
        else {
            iStudentManagerService.saveStudent(student);
            response.getWriter().println("<script language='javascript'>alert('添加成功！');location.href='/Student/queryStudent.do?id=-1';</script>");
        }
    }
    @RequestMapping("/selectStudent.do")//查看学生信息
    public String selectStudent(String id,String i,Model model)  {
        Student student = iStudentManagerService.findStudentById(id);
        model.addAttribute("student",student);
        if (i.equals("0")) {
            return "/page/updateStudent.jsp";
        }
        if(i.equals("1")){
            return "/page/showStudentMessage.jsp";
        }
        return null;
    }
    @RequestMapping("/updateStudent.do")//修改学生信息
    public String updateStudent(Student student) {
        iStudentManagerService.modifyStudent(student);
        return "/Student/queryStudent.do?id=-1";
    }
}
