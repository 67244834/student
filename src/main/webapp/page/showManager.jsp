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
    <script>
        function show() //显示隐藏层和弹出层
        {
            var hideobj=document.getElementById("hidebg");
            hidebg.style.display="block"; //显示隐藏层
//hidebg.style.height=document.body.clientHeight+"px"; //设置隐藏层的高度为当前页面高度
            document.getElementById("hidebox").style.display="block"; //显示弹出层
        }
        function hide() //去除隐藏层和弹出层
        {
            document.getElementById("hidebg").style.display="none";
            document.getElementById("hidebox").style.display="none";
        }
    </script>
    <style>
        #hidebg { position:absolute;left:0px;top:0px;
            background-color:#000;
            width:100%; /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
            height: 100%;
            filter:alpha(opacity=60); /*设置透明度为60%*/
            opacity:0.5; /*非IE浏览器下设置透明度为50%*/
            display:none;
            z-Index:2;}
        #hidebox { text-align: right;position:absolute;width:800px;height:450px;top:100px;left:20%;border-radius: 5px;background-color:#fff;display:none;z-Index:3;padding: 10px;}
        #content { text-align: center;cursor:pointer;z-Index:1;}
    </style>
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
                        ${mid}
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
                        ${manager.mname}
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
                        ${manager.sex}
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
                        ${manager.age}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>职位：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        ${manager.position}
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
                        ${manager.tel}
                    </label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="button bg-main icon-check-square-o" onClick="show();">修改
                </div>
            </div>
        </form>
    </div>
</div>
<div id="hidebg"></div>
<div id="hidebox">
    <div class="panel-head" align="center"><strong><span class="icon-pencil-square-o"></span>修改基本信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/Manager/updatemessage.do">
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="mname" value="${manager.mname}" placeholder="请输入姓名" data-validate="required:请输入姓名">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <select name="sex" class="input" style="width:99% ">
                        <option value="${manager.sex}">${manager.sex}</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>年龄</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="age" value="${manager.age}" data-validate="member:只能为数字" placeholder="请输入年龄" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>职位：</label>
                </div>
                <div class="field">
                    <input disabled type="text" class="input" name="position" value="${manager.position}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="tel" value="${manager.tel}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">保存</button>
                    <span onClick="hide();" class="button bg-main icon-check-square-o">关闭</span></div>
            </div>
        </form>
    </div>
</div>
</body></html>
