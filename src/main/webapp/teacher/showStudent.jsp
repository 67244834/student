<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">查看选课学生</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">学号</th>
                <th>姓名</th>
                <th>课程名称</th>
                <th>成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${score.datas}" var="s">
            <c:forEach items="${s.students}" var="sc">
                <c:forEach items="${sc.courses}" var="c">
                    <tr>
                        <td>${sc.sid}</td>
                        <td>${sc.sname}</td>
                        <td>${c.cname}</td>
                        <td>${c.score}</td>
                        <td>
                            <button class="button border-green" type="button" onclick="location.href='${ctx}/teacher/upinsert.jsp?sid=${sc.sid}&sname=${sc.sname}&cname=${c.cname}&score=${c.score}&cid=${c.cid}'"><span class="icon-check">添加/修改成绩</span></button>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </c:forEach>
            <tr>
                <td colspan="8"><div class="pagelist"> <a href="${ctx}/teacher/pick/showStudent.do?pageno=1">首页</a><a href="${ctx}/teacher/pick/showStudent.do?pageno=${score.pageno-1>1 ? course.pageno-1:1}">上一页</a> <a href="${ctx}/teacher/pick/showStudent.do?pageno=${score.pageno+1<score.totalPages?score.pageno+1:score.totalPages}">下一页</a><a href="${ctx}/teacher/pick/showStudent.do?pageno=${score.totalPages}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
</body></html>