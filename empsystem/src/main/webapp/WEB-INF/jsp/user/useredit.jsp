<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${ctx}/">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="assets/user/edit.css">
    <script src="assets/lib/jquery/jquery-3.6.3.min.js"></script>
    <script src="assets/lib/layer/layer.js"></script>
    <script>
        const error = "${error}";
        const sex = "${emps.sex}";
        const ctx = "${ctx}";
    </script>

    <script src="assets/user/edit.js"></script>
</head>
<body>

<form id="user-form" action="user/edit" method="post">
    <div class="container">
        <h1>修改账户信息</h1>
        <div>
            <label for="username" class="required" >账号(*)：</label>
            <input type="text" id="username"
                   autocomplete="off" name="username" placeholder="请输入账号，不可为空" >
        </div>
        <div>
            <label for="password" class="required">原始密码(*)： </label>
            <input type="text" id="password" name="password" autocomplete="off" placeholder="请输入原始密码，不可为空">
        </div>
        <div>
            <label for="newpassword" class="required">新密码(*)： </label>
            <input type="text" id="newpassword" name="newpassword" autocomplete="off" placeholder="请输入新密码，不可为空" ">
        </div>
        <div>
            <label for="newpassword2" class="required">重复密码(*)： </label>
            <input type="text" id="newpassword2" name="newpassword2" autocomplete="off" placeholder="请输入新密码，不可为空" ">
        </div>
        <div>
            <label for=""></label>
            <button type="button" id="submit-btn" >提交</button>
            <button type="reset">重置</button>
        </div>
        <h1>--------------------------------------------------------------------</h1>
    </div>
    </div>
</form>
</body>
</html>
