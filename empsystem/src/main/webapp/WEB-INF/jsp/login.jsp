<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${ctx}/">
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="assets/employee/css/login.css">
    <script src="assets/lib/jquery/jquery-3.6.3.min.js"></script>
    <script src="assets/lib/layer/layer.js"></script>
    <script src="assets/login/login.js"></script>
    <script>
        const ctx = "${ctx}";
        const error = "${error}";
    </script>
</head>
<body>
<form id="login-form " action="user/login" method="post">
    <div class="container">
        <div class="tit">登录</div>
        <label>账号</label><input type="text" name="username" placeholder="请输入账号" id="username">
        <label>密码</label><input type="password" name="password" placeholder="请输入密码" id="password">
        <label>验证码</label><input type="text" name="captcha">
        <img id="captcha" src="user/captcha">

        <button id="login-btn">登录</button>
        <span>没有账号？<a href="#">去注册</a> </span>
    </div>
    <div class="square">
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <div class="circle">
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</form>
</body>
</html>

