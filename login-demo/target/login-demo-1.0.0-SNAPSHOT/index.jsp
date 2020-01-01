<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/1/1
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <input type="text" name="loginId">
        <input type="password" name="loginPwd">
        <input type="submit" value="Login">

    </form>
</body>
</html>
