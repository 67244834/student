<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>基本信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x">
            <div class="form-group">
                <div class="label">
                    <label>标识：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.sid}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.sname}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.sex}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>年龄：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.age}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>班级：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.garde}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>学历：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.education}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>所属院校：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.school}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>电话：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.tel}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>地址：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${student.address}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                <button class="button bg-main icon-check-square-o" type="button" onClick="window.location.href='javascript:history.go(-1)'">关闭</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
