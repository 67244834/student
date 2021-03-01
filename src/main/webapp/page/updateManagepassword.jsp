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
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span>修改密码</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" >
            <div class="form-group">
                <div class="label">
                    <label>管理员帐号：</label>
                </div>
                <div class="field">
                    <label style="line-height:33px;">
                        <input type="text"  value="${mid}" class="input w50" id="mid" id = "mid"  size="50"  disabled />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">原始密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" id="newpass" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="sitename">确认新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button disabled="disabled" class="button bg-main icon-check-square-o" type="button"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
        $("button").click(function () {
            var mid = document.getElementById("mid").value;
            var mpass = document.getElementById("mpass").value;
            var newpass = document.getElementById("newpass").value;
            console.log(mid+mpass,newpass);
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/Manager/updatepassword.do",
                contentType:"application/json",
                dataType:'json',
                data:JSON.stringify({"mid":mid,"mpass":mpass,"newpass":newpass}),
                success:function (data) {
                    if (data == "1") {
                        alert("修改成功！");
                        window.top.location.href="/login.jsp";
                    }
                    else {
                        alert('修改失败！请检查是否输入错误！');
                    }
                }
            });
        });

        $(":input").change(function(){

            var button = $(":button");
            if($(this).val()!=""){
                button.removeAttr("disabled");
            }else{
                button.attr("disabled","disabled");
            }
        });
</script>
</body></html>
