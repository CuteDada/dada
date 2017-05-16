<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎登陆</title>
    <link rel="stylesheet" type="text/css" href="css/canvas/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/canvas/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/canvas/component.css" />
    <link rel="stylesheet" type="text/css" href="css/login-style.css" />
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/canvas/TweenLite.min.js"></script>
<script src="js/canvas/EasePack.min.js"></script>
<script src="js/canvas/rAF.js"></script>
<script src="js/canvas/demo-1.js"></script>


<div class="login main-title">
    <div class="login-top">
        <h1>欢迎登陆</h1>
        <form method="post" action="login.do" onsubmit="return loginCheck()">
            <input type="text" id="username" name="username" placeholder="用户名">
            <br><br>
            <input type="password" id="password" name="password" placeholder="密码">
            <br><br>
            <div class="forgot">
                <a href="toResetPassword.do">忘记密码</a>
                <input type="submit" value="登录" id="login">
            </div>
        </form>
        <hr/>

        <p id="error-info" class="error-info">${error}</p>

    </div>
    <div class="login-bottom">
        <h3> &nbsp;<a href="toRegister.do">没有账号？点击注册</a>&nbsp;</h3>
    </div>
</div>
</body>
</html>

