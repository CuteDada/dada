<%--
  Created by IntelliJ IDEA.
  User: tian
  Date: 2017/5/17
  Time: 下午4:30
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
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
    <script type="text/javascript" src="js/register.js"></script>
    <script src="js/canvas/TweenLite.min.js"></script>
    <script src="js/canvas/EasePack.min.js"></script>
    <script src="js/canvas/rAF.js"></script>
    <script src="js/canvas/demo-1.js"></script>

    <div class="login main-title">
        <div class="login-top" style="height:480px;">
            <h1>基本信息</h1>
            <form method="post" action="baseRegister.do" onsubmit="return registerCheck()">
                <input type="text" value="${username}" id="username" name="username" placeholder="用户名:3-10位">
                <br><br>
                <input type="text" value="${email}" id="email" name="email" placeholder="邮箱">
                <br><br>
                <input type="password" value="${password}" id="password" name="password" placeholder="密码:6-20位">
                <br><br>
                <input type="password" value="${password2}" id="password2" name="password2" placeholder="请再次输入密码">
                <br><br>
                <p id="error-info" class="error-info">${error}</p>
                <br>
                <hr/>
                <div class="forgot">
                    <input type="submit" value="点击注册" id="register">
                </div>
            </form>

        </div>
        <div class="login-bottom">
            <h3> &nbsp;<a href="toLogin.do">已有账号？点击登录</a>&nbsp;</h3>
        </div>
    </div>

</body>

</html>
