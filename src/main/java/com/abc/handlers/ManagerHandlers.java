package com.abc.handlers;

import com.abc.beans.Manager;
import com.abc.service.ILoginService;
import com.abc.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/Manager")
public class ManagerHandlers {
    @Autowired
    ILoginService iLoginService;
    @Autowired
    IManagerService iManagerService;
    @ResponseBody
    @RequestMapping(value = "/updatepassword.do" ,method = RequestMethod.POST)
    public String  doAjax1(@RequestBody Map<String,Object> jsonData) {
        String mid= jsonData.get("mid").toString();
        String mpass= jsonData.get("mpass").toString();
        String newpass= jsonData.get("newpass").toString();
        String ypass=iLoginService.findmpassword(mid);
        if (mpass.equals(ypass)){
            iManagerService.updatepassword(newpass,mid);
            return "1";
        }
        else {
            return "0";
        }
    }
    @RequestMapping("/selectmanager.do")
    public String selectmangerpassword(Model model, HttpSession session) throws Exception {
        String mid= (String) session.getAttribute("mid");
        Manager manager=iManagerService.findmanager(mid);
        model.addAttribute("manager",manager);
        return "/page/showManager.jsp";
    }
    @RequestMapping("/updatemessage.do")
    public void updatemessage(Model model,Manager manager,HttpServletResponse response,  HttpSession session) throws Exception {
        String mid= (String) session.getAttribute("mid");
        manager.setMid(mid);
        iManagerService.updatemessage(manager);
        response.getWriter().println("<script language='javascript'>alert('修改成功！');location.href='/Manager/selectmanager.do';</script>");
    }

}
