package com.abc.handlers;

import com.abc.beans.Course;
import com.abc.beans.Page;
import com.abc.service.ICourseManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/Course")
public class CourseManagerHandlers {
    @Autowired
    private ICourseManagerService iCourseManagerService;

    @RequestMapping("/queryCourse.do")
    public String queryCourse(String id,String a, @RequestParam(defaultValue = "1")int pageno , Model model){
        if("-1".equals(id)){  //查询全部
            Page<Course> page = iCourseManagerService.findCoursemessage(pageno);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "请选择查询方式";
            model.addAttribute("arr",arr);
            return "/page/courseMessage.jsp";
        }
        if("1".equals(id)){  //精确查询
            Page<Course> page = iCourseManagerService.findCoursemessage1(pageno,a);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "精确查询";
            model.addAttribute("arr",arr);
            return "/page/courseMessage.jsp";
        }
        if("2".equals(id)){ //模糊查询
            Page<Course> page = iCourseManagerService.findCoursemessage2(pageno,a);
            model.addAttribute("page",page);
            model.addAttribute("id",id);
            model.addAttribute("a",a);
            String arr = "模糊查询";
            model.addAttribute("arr",arr);
            return "/page/courseMessage.jsp";
        }
        return "/page/courseMessage.jsp";
    }
    @RequestMapping("/delCourse.do")//删除课程信息
    public String delCourse(String cid)  {
        iCourseManagerService.removeCourseById(cid);
        return "/Course/queryCourse.do?id=-1";
    }
    @RequestMapping("/delAllCourse.do")//删除全部课程信息
    public String delAllCourse(String cid) {
        String id[]=cid.split(",");
        for(int i=0;i<id.length;i++){
            iCourseManagerService.removeCourseById(id[i]);
        }
        return "/Course/queryCourse.do?id=-1";
    }
    @RequestMapping("/addCourse.do")//添加课程信息
    public void addCourse (Course course,HttpServletResponse response) throws Exception {
        String cid= course.getCid();
        Course course1 = iCourseManagerService.findCourseById(cid);
        if (course1!=null) {
            response.getWriter().println("<script language='javascript'>alert('课程号重复，请重新检查后重新添加！');window.history.back(-1);</script>");
        }
        else {
            if (course.getTid().isEmpty()){
                iCourseManagerService.saveCourse1(course);
                response.getWriter().println("<script language='javascript'>alert('添加成功！');location.href='/Course/queryCourse.do?id=-1';</script>");

            }
            else {
                iCourseManagerService.saveCourse(course);
                response.getWriter().println("<script language='javascript'>alert('添加成功！');location.href='/Course/queryCourse.do?id=-1';</script>");
            }
        }
    }

    @RequestMapping("/selectCourse.do")//查看课程信息
    public String  selectCourse(String id,String i ,Model model)  {
        Course course = iCourseManagerService.findCourseById(id);
        model.addAttribute("course",course);
        if (i.equals("0")) {
            return "/page/updateCourse.jsp";
        }
        if(i.equals("1")){

        }
        return null;
    }
    @RequestMapping("/updateCourse.do")//修改个人信息
    public String updateCourse(Course course) {
        iCourseManagerService.modifyCourse(course);
        return "/Course/queryCourse.do?id=-1";
    }
}
