<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<h2>Welcome to dada!</h2>
<c:if test="${not empty user}">
    <p>hello,${user.username}</p>
    <img class="mid_pic" src="getUserPic.do">
</c:if>
</body>
</html>
