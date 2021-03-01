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
        <div class="panel-head"><strong class="icon-reorder">退选</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">ID</th>
                <th>课程名称</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${tpick.datas}" var="cs" varStatus="a">
                <tr>
                    <td>${cs.cid}</td>
                    <td>${cs.cname}</td>
                    <td><c:if test="${cs.tid==null||cs.tid==''}">
                        <button class="button border-red">未选择</button>
                    </c:if>
                        <c:if test="${cs.tid!=null||cs.tid!=''}">
                            <button class="button border-green">已选择</button>
                        </c:if>
                    </td>
                    <td class="td-manage">
                        <button  type = "button" onclick="pick(this,this.id)" class="button border-red"><span class="icon-check">退选</span></button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8"><div class="pagelist"> <a href="${ctx}/teacher/pick/showpickCourse.do?pageno=1">首页</a><a href="${ctx}/teacher/pick/showpickCourse.do?pageno=${tpick.pageno-1>1 ? tpick.pageno-1:1}">上一页</a> <a href="${ctx}/teacher/pick/showpickCourse.do?pageno=${tpick.pageno+1<tpick.totalPages?tpick.pageno+1:tpick.totalPages}">下一页</a><a href="${ctx}/teacher/pick/showpickCourse.do?pageno=${tpick.totalPages}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
<script>
    function pick(obj,id) {
        var td = $(obj).parents("tr").children("td");
        var cid = td.eq(0).text();
        var str = confirm("确定退选选此课程？");
        if(str==true){

            $.ajax({
                type:"post",
                data:JSON.stringify({"cid":cid}),
                dataType:"json",
                contentType:"application/json",
                url:"${ctx}/teacher/pick/ttpickCourse.do",
                success:function (data) {
                    if (data = "1")
                    alert("退选成功")
                    location.href="${ctx}/teacher/pick/showpickCourse.do"
                },
                error:function () {
                    alert("退选失败")
                }
            })
        }
    }
</script>
</body></html>