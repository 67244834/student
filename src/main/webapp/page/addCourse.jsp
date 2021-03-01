
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/pintuer.js"></script>
    <script charset="utf-8" language="javascript" type="text/javascript" src="JS/CommonFields/common.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加学生</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/Course/addCourse.do">
            <div class="form-group">
                <div class="label">
                    <label>*课程号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="cid" data-validate="required:请输入课程号" />
                </div>
            </div>
            <div class="clear"></div>
            <div class="form-group">
                <div class="label">
                    <label>*课程名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="cname" value="" data-validate="required:请输入课程名称"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>任课老师ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="tid" value="" />
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
</div>

</body></html>