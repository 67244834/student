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
  <link rel="stylesheet" href="../css/pintuer.css">
  <link rel="stylesheet" href="../css/admin.css">
  <script src="../js/jquery.js"></script>
  <script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改分类</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${ctx}/teacher/pick/upScore.do?cid=${param.cid}">
      <div class="form-group">
        <div class="label">
          <label>学号</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sid" readonly ="readonly" value="${param.sid}"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>姓名</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sname" readonly ="readonly" value="${param.sname}"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程名称</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="cname" readonly ="readonly" value="${param.cname}"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>成绩</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="score" value="${param.score}"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>