<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${ctx}/">
    <meta charset="utf-8"/>
    <title>强盛企业人力资源管理</title>
    <link rel="stylesheet" href="assets/index/index.css">
    <script src="assets/lib/jquery/jquery-3.6.3.min.js"></script>
    <script src="assets/lib/layer/layer.js"></script>
    <script src="assets/index/index.js"></script>
    <script>
        const ctx = "${ctx}";
    </script>
</head>
<body>
<header>
    <h1>尊敬的用户[${user.username}]您好，欢迎使用本系统</h1>
    <div class="logout">
        <a id="edit-btn" href="javascript:void(0)">修改个人信息</a>
        <a href="javascript:void(0)">退出登录</a>
    </div>
</header>

<div class="ctr clear">
    <div class="fl lft">
        <ul class="nav">
            <li><a href="" id="index">首页</a></li>
            <li><a href="employee/list">员工列表</a></li>
            <li><a href="employee/add">添加员工</a></li>
            <li><a href="department/list">部门列表</a></li>
            <li><a href="department/add">添加部门</a></li>
        </ul>
    </div>
    <div class="fl main">
        <iframe src="http://sfh666.top">

        </iframe>
    </div>
</div>

<footer> <p2>姓名：邵福豪/邮箱：1374487363@qq.com</p2></footer>
</body>
</html>