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
        <div class="panel-head"><strong class="icon-reorder">教师选课</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">ID</th>
                <th>课程名称</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${course.datas}" var="cs" varStatus="a">
                <tr>
                    <td>${cs.cid}</td>
                    <td>${cs.cname}</td>
                    <td class="td-manage">
                        <c:if test="${cs.tid==null||cs.tid==''}">
                            <button class="button border-red"><span class="icon-check">未选择</span></button>
                        </c:if>
                        <c:if test="${cs.tid!=null}">
                            <button class="button border-green"><span class="icon-check">已选择</span></button>
                        </c:if>
                    </td>
                    <td class="td-manage">
                        <button onclick="pick(this,this.id,${cs.tid})" class="button border-green"><span class="icon-check">选择</span></button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8"><div class="pagelist"> <a href="${ctx}/teacher/pick/showAllCourse.do?pageno=1">首页</a><a href="${ctx}/teacher/pick/showAllCourse.do?pageno=${course.pageno-1>1 ? course.pageno-1:1}">上一页</a><a href="${ctx}/teacher/pick/showAllCourse.do?pageno=${course.pageno+1<course.totalPages?course.pageno+1:course.totalPages}">下一页</a><a href="${ctx}/teacher/pick/showAllCourse.do?pageno=${course.totalPages}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
<script>
    function pick(obj,id,tid) {
        var td = $(obj).parents("tr").children("td");
        var cid = td.eq(0).text();

        var str = confirm("确定选择此课程？");
        if(str==true){
            $.ajax({
                type:"post",
                data:{cid:cid,tid:tid},
                url:"${ctx}/teacher/pick/tpickCourse.do",
                success:function () {
                    if(!tid)
                        alert("选课成功")
                    else
                        alert("课程已被选择！")
                },
                error:function () {
                    if(tid)
                    alert("课程已被选择！")
                    else{
                        alert("选课成功")
                    }
                }
            })
        }
    }
</script>
</body></html>