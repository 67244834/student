
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
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/Student/addStudent.do">
            <div class="form-group">
                <div class="label">
                    <label>*姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="sname" data-validate="required:请输入姓名" />
                </div>
            </div>
            <div class="clear"></div>
            <div class="form-group">
                <div class="label">
                    <label>*学号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="sid" value="" data-validate="required:请输入学号"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>*性别：</label>
                </div>
                <div class="field">
                    <select name="sex" class="input w50" >
                        <option value="男">请选择：默认为男</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>*年龄：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="age" value="" data-validate="member:只能为数字" data-validate="required:请输入年龄"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>班级：</label>
                </div>
                <div class="field">
                    <div class="field">
                        <input type="text" class="input w50" name="garde" value="" />
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>所属学院：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="school" value=""  />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>学历：</label>
                </div>
                <div class="field">
                    <select name="education" class="input w50" >
                        <option value="无">请选择：默认无</option>
                        <option value="专科">专科</option>
                        <option value="本科">本科</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>地址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="address" value="" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="tel" value="" data-validate="member:只能为数字"  />
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
</div>

</body></html>