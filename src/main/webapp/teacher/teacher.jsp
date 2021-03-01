<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="../images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-red" href="javascript:window.close();location.href='${ctx}/Login/exit.do'"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="${ctx}/teacher/pick/showAllCourse.do" target="right"><span class="icon-caret-right"></span>正选</a></li>
    <li><a href="${ctx}/teacher/pick/showpickCourse.do" target="right"><span class="icon-caret-right"></span>查看选课</a></li>
      <li><a href="${ctx}/teacher/pick/showStudent.do" target="right"><span class="icon-caret-right"></span>查看选课学生</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>基本设置</h2>
  <ul>
    <li><a href="/teacher/teacherpass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="${ctx}/teacher/pick/showtUser.do" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="/welcome.jsp" target="right" class="icon-home">首页</a></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="/welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>