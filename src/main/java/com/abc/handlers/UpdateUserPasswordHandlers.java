package com.abc.handlers;

import com.abc.service.IStudentManagerService;
import com.abc.service.ITeacherManagerService;
import com.abc.service.IUpdateUserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2021/1/5 0005
 */
@Controller
@RequestMapping("/UpdateUser")
public class UpdateUserPasswordHandlers {
    @Autowired
    private IUpdateUserPasswordService iUpdateUserPasswordService;
    @RequestMapping("/updatepassword.do")
    public void updateTeacherpassword(String flag,String user,String renewpass, HttpServletResponse response) throws IOException {
        if(flag.equals("1")){
                iUpdateUserPasswordService.updateTeacherpassword(renewpass,user);
        }else{

                iUpdateUserPasswordService.updateStudentpassword(renewpass,user);
        }
        response.getWriter().println("<script language='javascript'>alert('修改成功！');location.href='/page/updateUserpassword.jsp';</script>");
    }
}
