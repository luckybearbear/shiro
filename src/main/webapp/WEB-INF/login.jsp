<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/23
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ page contentType="text/html;charset=UTF-8" language="java"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
        <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <title>登录</title>
            <!-- Javascript -->
            <script src="${pageContext.request.contextPath}/static/jquery-1.7.2.js"></script>
            <script type="text/javascript">
                //登录
                function login() {
                    if ($("#userName").val() == null || $("#userName").val() == '') {
                        alert("请输入用户名！");
                    } else if ($("#pwd").val() == null || $("#pwd").val() == "") {
                        alert("密码不能为空！");
                    } else {
                        document.getElementById("form").submit();
                    }

                }
                //keydowm登录
                function keydown_login() {
                    document.onkeydown = function (e){
                        var theEvent = window.event || e;
                        var code = theEvent.keyCode || theEvent.which;
                        if (code == 13 && (null != $("#pwd").val())) {
                            theEvent.returnValue = false;
                            theEvent.cancel = true;
                            document.getElementById("form").submit();
                        }
                    }
                }
            </script>
        </head>
<body>
<form  method="post" id="form" action="${pageContext.request.contextPath}/loginTest">
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="username" id="userName" />
        <label style="color: red; font-size: 14px; float: right; margin-right: 35px;">${message}</label>
    </div>
    <div class="form-group">
        <label >Password</label>
        <input type="password" name="password" id="pwd" />
    </div>
    <div class="checkbox">
        <label><input type="checkbox" name="rememberMe"/> RemeberMe</label>
    </div>
    <button type="button" class="btn" onclick="login()">Sign in!</button>
</form>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
