<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 正选结果</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">课程ID</th>
                <th>课程名称</th>
                <th>课程成绩</th>
                <th>授课老师</th>
                <th width="310">操作</th>
            </tr>
            <c:forEach items="${studentCourse.datas}" var="s">
            <c:forEach items="${s.courses}" var="sc">
            <c:forEach items="${sc.teachers}" var="ta">
                <tr>
                    <td>${sc.cid}</td>
                    <td>${sc.cname}</td>
                    <td>${sc.score}</td>
                    <td>${ta.tname}</td>
                    <td><div class="td-manage"> <a class="button border-main" href="${pageContext.request.contextPath}/student/deleteStudentSC.do?cid=${sc.cid}" onclick="tuixuan()"><span class="icon-trash-o"></span>退选</a>  </div></td>
                </tr>
            </c:forEach>
            </c:forEach>
            </c:forEach>
            <tr>
                <td colspan="8"><div class="pagelist">
                    <a href="${pageContext.request.contextPath}/student/selectStudentSC.do?pageno=1">首页</a>
                    <a href="${pageContext.request.contextPath}/student/selectStudentSC.do?pageno=${studentCourse.pageno-1>1 ? studentCourse.pageno-1:1}">上一页</a>
                    <a href="${pageContext.request.contextPath}/student/selectStudentSC.do?pageno=${studentCourse.pageno+1<studentCourse.totalPages?studentCourse.pageno+1:studentCourse.totalPages}">下一页</a>
                    <a href="${pageContext.request.contextPath}/student/selectStudentSC.do?pageno=${studentCourse.totalPages}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    function tuixuan()
    {
        var str = confirm("是否确定退选此课程？");
        if(str == true)
        {
            alert("退选成功！");
        }
    }
</script>
</body>
</html>