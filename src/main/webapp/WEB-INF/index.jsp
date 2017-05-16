<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<h2>Welcome to dadaVote!</h2>
<c:if test="${not empty username}">
    <p>hello,${username}</p>
    <img class="mid_pic" src="getUserPic.do">
</c:if>
</body>
</html>
