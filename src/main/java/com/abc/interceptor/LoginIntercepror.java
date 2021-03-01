package com.abc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

public class LoginIntercepror implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri=request.getRequestURI();
        if (uri.indexOf("/login.jsp")>=0||uri.indexOf("/Login/login.do")>=0){
            return true;
        }
        HttpSession session =request.getSession();
        String user= (String) session.getAttribute("user_session");
        if (user!=null){
            return true;
        }
        request.setAttribute("msg","你还没有登录，请登录！");
        // request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
        response.getWriter().println("<script language='javascript'>window.top.location.href = '/login.jsp';</script>");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}