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
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/Teacher/updateTeacher.do?tid=${teacher.tid}">
        <div class="form-group">
            <div class="label">
                <label>姓名：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="tname" value="${teacher.tname}" placeholder="请输入姓名" data-validate="required:请输入姓名">
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>性别：</label>
            </div>
            <div class="field">
                <select name="sex" class="input" >
                    <option value="${teacher.sex}">${teacher.sex}</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>年龄:</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="age" value="${teacher.age}" data-validate="member:只能为数字" placeholder="请输入姓名" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>所属院校：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="school" value="${teacher.school}" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>电话：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="tel" value="${teacher.tel}" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>工作年龄：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="worktime" value="${teacher.worktime}" data-validate="member:只能为数字" placeholder="请输入姓名" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>学历：</label>
            </div>
            <div class="field">
                <select name="education" class="input" >
                    <option value="${teacher.education}">${teacher.education}</option>
                    <option value="专科">专科</option>
                    <option value="本科">本科</option>
                    <option value="无">无</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>地址：</label>
            </div>
            <div class="field">
                <input type="text" class="input" name="address" value="${teacher.address}" />
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
