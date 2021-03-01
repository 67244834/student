package com.abc.handlers;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.beans.Student;
import com.abc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private IStudentService service;
    @RequestMapping("/findStudent.do")
    public String findStudent(HttpSession session){
        String id= (String) session.getAttribute("id");
        Student student=service.findStudentById(id);
        session.setAttribute("studentst",student);
        return "/student/studentst.jsp";
    }
    @RequestMapping("/updateStudent.do")
    public String updateStudent(HttpSession session,Student student){
        service.updateStudentById(student);
        return "/student/findStudent.do";
    }
    @RequestMapping("/upteUserPassword.do")
    public String upteUserPassword(HttpSession session, HttpServletRequest request,String id,String renewpass,String mpass)  {

        String edu ="";
        Student student = service.findStudentById(id);
        if (!mpass.equals(student.getPassword())) {
            edu="修改失败，请检查后再进行尝试！";
        }else {
          service.updatePassword(id,renewpass);
            edu="修改成功，请重新登录！";
        }
        request.setAttribute("edu",edu);
        return "/student/studentpass.jsp?";
    }

    @RequestMapping("/selectAllCourse.do")
    public String selectAllCourse(@RequestParam(defaultValue = "1") int pageno,HttpServletRequest request,HttpSession session){
        Page<Course> page = new Page<Course>();
        String id= (String) session.getAttribute("id");
        page=service.findAllCourse(pageno);
        List<String> Cids=service.findSCCidBySid(id);
        request.setAttribute("courseList",page);
        request.setAttribute("Cids",Cids);
        return "/student/studentpick.jsp";
    }

    @RequestMapping("/addSC.do")
    private String addSC(HttpSession session,String cid,HttpServletRequest request){
        boolean flag=true;
        String id= (String) session.getAttribute("id");
        List<String> list=service.selectSCByid(id);
        for (String course:list){
            if (course.equals(cid)){
                flag=false;
            }
        }
        if (flag){
        service.insertStudentCourse(id,cid);
        }
        return "/student/selectAllCourse.do";
    }
    @RequestMapping("/selectStudentSC.do")
    private String selectStudentSC(@RequestParam(defaultValue = "1") int pageno,HttpSession session){
        Page<Student> page = new Page<Student>();
        String id= (String) session.getAttribute("id");
        page =service.findStudentCourseById(id,pageno);
        session.setAttribute("studentCourse",page);
        return "/student/studentsc.jsp";
    }
    @RequestMapping("/deleteStudentSC.do")
    public String deleteStudentSC(HttpSession session,String cid){
        String sid= (String) session.getAttribute("id");
        service.removeStudentSC(sid,cid);
        return "/student/selectStudentSC.do";
    }

}