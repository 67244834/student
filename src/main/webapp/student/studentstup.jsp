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
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改个人信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${ctx}/student/updateStudent.do">
            <div class="form-group">
                <div class="label">
                    <label>学号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="sid" readonly="readonly" value="${studentst.sid}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="sname" value="${studentst.sname}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别</label>
                </div>
                <div class="field">
                    <select name="sex" class="input w50">
                        <option value="男">
                            男
                        </option>
                        <option value="女">
                            女
                        </option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>年龄：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="age"  value="${studentst.age}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>学校：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="school" value="${studentst.school}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>年级：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="garde" value="${studentst.garde}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>学历：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="education"  value="${studentst.education}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>联系方式：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="tel" value="${studentst.tel}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>家庭住址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="address" value="${studentst.address}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button" onclick="xiugai()" type="submit">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function xiugai()
    {
        var str = confirm("确定保存此信息？");
        if(str == true)
        {
            alert("保存成功！");
        }
    }
</script>
</body></html>