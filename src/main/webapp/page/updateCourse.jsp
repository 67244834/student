<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="panel-head" align="center"><strong><span class="icon-pencil-square-o"></span>修改基本信息</strong></div>
<div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/Course/updateCourse.do?cid=${course.cid}">
        <div class="form-group">
            <div class="label">
                <label>课程号：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="cid" value="${course.cid}" disabled >
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>课程名称：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="cname" value="${course.cname}" placeholder="请输入课程名称" data-validate="required:请输入课程名称>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>任课老师ID：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="tid" value="${course.tid}" >
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label></label>
            </div>
            <div class="field">
                <button class="button bg-main icon-check-square-o" type="submit">保存</button>
                <button class="button bg-main icon-check-square-o" type="button" onClick="window.location.href='javascript:history.go(-1)'">关闭</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
