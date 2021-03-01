<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;"></a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a href="${pageContext.request.contextPath}/page/addCourse.jsp"><button type="button" class="button border-main icon-plus-square-o" >添加内容</button></a> </li>
                <li>搜索：</li>
                <if condition="$iscid eq 1">
                    <li>
                        <select id="select" name="select" class="input" style="width:200px; line-height:17px;">
                            <option value="${id}">${id=="-1"?"请选择查询方式":arr}</option>
                            <c:if test="${id!='-1'?true:false}"><option value="-1">请选择查询方式</option></c:if>
                            <c:if test="${id!='1'?true:false}"><option value="1">精确查询</option></c:if>
                            <c:if test="${id!='2'?true:false}"><option value="2">模糊查询</option></c:if>
                        </select>
                    </li>
                </if>
                <li>
                    <input value="${a}" type="text" placeholder="请输入搜索关键字" name="select2" id="select2" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <button type="button" class="button border-main icon-search" onclick="changesearch()" > 搜索</button></li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">序号</th>
                <th width="120">课程号</th>
                <th width="120">课程名称</th>
                <th width="120">任课老师ID</th>
                <th width="120">操作</th>
            </tr>
            <c:forEach items="${page.datas}" var="nl">
                <tr>
                    <td style="text-align:left; padding:19px 0;padding-left:20px;"><input  type="checkbox" id="id[]" value="${nl.cid}"/></td>
                    <td width="120">${nl.cid}</td>
                    <td width="120">${nl.cname}</td>
                    <td width="120">${nl.tid}</td>
                    <td width="240">
                        <div class="button-group">
                            <a class="button border-main" href="${pageContext.request.contextPath}/Course/selectCourse.do?id=${nl.cid}&i=0"><span class="icon-edit"></span>修改</a>
                            <a class="button border-red" href="${pageContext.request.contextPath}/Course/delCourse.do?cid=${nl.cid}"><span class="icon-trash-o"></span> 删除</a>
                        </div></td>
                </tr>
            </c:forEach>

            <td style="text-align:left; padding:19px 0; padding-left:20px;"> <button type="button" class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button></td>
            <td colspan="7" style="text-align:left;padding-left:20px;"><button type="button" class="button border-red icon-trash-o"  onclick="DelSelect()"> <span class="icon-check"></span> 批量删除</button></td>


            <tr>
                <td colspan="8"><div class="pagelist"> <a href="${pageContext.request.contextPath}/Course/queryCourse.do?pageno=${page.pageno-1>1?page.pageno-1:1}&id=${id}&a=${a}">上一页</a> <span class="current">1</span><a href="${pageContext.request.contextPath}/Course/queryCourse.do?pageno=${page.pageno+1<page.totalPages?page.pageno+1:page.totalPages}&id=${id}&a=${a}">下一页</a><a href="${pageContext.request.contextPath}/Course/queryCourse.do?pageno=${page.totalPages}&id=${id}&a=${a}">尾页</a> </div></td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){
        var myselect=document.getElementById("select");
        var index=myselect.selectedIndex;
        var arr1=myselect.options[index].value;
        var a=document.getElementById("select2").value;
        if(a==""&&arr1==-1){
            location.href="${pageContext.request.contextPath}/Course/queryCourse.do?id=-1";
        }
        if(a!=""&&arr1==-1){
            alert("请选择查询条件");
        }
        if(a==""&&arr1!=-1){
            alert("请输入正确的关键字")
        }
        if (a!=""&&arr1!=-1){
            location.href="${pageContext.request.contextPath}/Course/queryCourse.do?id="+arr1+"&a="+a;
        }
    }

    //全选
    $("#checkall").click(function() {
        if ($("input[id='id[]']").is(":checked")) {

            $("input[id='id[]']").prop('checked',false);
        } else {

            $("input[id='id[]']").prop('checked',true);
        }
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[id='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            if(t==true) {
                var arr = [];
                $("input[id='id[]']:checked").each(function(i){
                    arr.push($(this).val());
                });
                location.href="${pageContext.request.contextPath}/Course/delAllCourse.do?cid="+arr;
            }
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>