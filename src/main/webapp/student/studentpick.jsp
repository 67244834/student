<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 正选</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">课程ID</th>
                <th>课程名称</th>
                <th>授课老师</th>
                <th>状态</th>
                <th width="310">操作</th>
            </tr>
            <c:forEach items="${courseList.datas}" var="cs">
            <c:forEach items="${cs.teachers}" var="t">
                <tr>
                    <td>${cs.cid}</td>
                    <td>${cs.cname}</td>
                    <td>${t.tname}</td>
                    <c:if test="${Cids.size()==0}">
                        <td>未选择</td>
                    </c:if>
                    <c:if test="${Cids.size()!=0}">
                        <c:set var="i" value="false"/>
                    <c:forEach items="${Cids}" var="cid">
                        <c:if test="${cs.cid==cid}">
                        <td>已选择</td>
                            <c:set var="i" value="true"/>
                        </c:if>
                    </c:forEach>
                        <c:if test="${!i}">
                            <td>未选择</td>
                        </c:if>
                    </c:if>
                    <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/student/addSC.do?cid=${cs.cid}" onclick="tianjia()"><span class="icon-edit"></span>添加</a>  </div></td>
                </tr>
            </c:forEach>
            </c:forEach>
            <tr>
                <td colspan="8"><div class="pagelist"> <a href="${pageContext.request.contextPath}/student/selectAllCourse.do?pageno=1">首页</a>
                    <a href="${pageContext.request.contextPath}/student/selectAllCourse.do?pageno=${courseList.pageno-1>1 ? courseList.pageno-1:1}">上一页</a>
                    <a href="${pageContext.request.contextPath}/student/selectAllCourse.do?pageno=${courseList.pageno+1<courseList.totalPages?courseList.pageno+1:courseList.totalPages}">下一页</a>
                    <a href="${pageContext.request.contextPath}/student/selectAllCourse.do?pageno=${courseList.totalPages}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    function tianjia()
    {
        var str = confirm("是否确定选择此课程？");
        if(str == true)
        {
            alert("选课成功！");
        }
    }
</script>
</body>
</html>