<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${ctx}/">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="assets/employee/css/add.css">
    <script src="assets/lib/jquery/jquery-3.6.3.min.js"></script>
    <script src="assets/lib/layer/layer.js"></script>
    <script src="assets/lib/laydate/laydate.js"></script>
    <script>
        const error = "${error}";
        const ctx = "${ctx}";
    </script>

    <script src="assets/employee/js/adddept.js"></script>
</head>
<body>

<form id="dept-form" action="department/add" method="post">
    <div class="container">
        <h1>添加部门所属信息</h1>
        <div>
            <label for="depId" class="required">部门编号(*)：</label><input type="text" id="depId"
                                                                  autocomplete="off" name="depId" value="${dept.depId}">
        </div>
        <div>
            <label for="name" class="required">部门名称(*)： </label><input type="text" id="name" autocomplete="off" name="name" value="${dept.name}">
        </div>
        <div>
            <label for="leader">部门领导:</label><input type="text" id="leader" autocomplete="off" name="leader" value="${dept.leader}">
        </div>
        <div>
            <label for=""></label>
            <button id="submit-btn" type="button">提交</button>
            <button type="reset" id="reset-button">重置</button>
        </div>
        <h1>--------------------------------------------------------------------</h1>
    </div>
    </div>
</form>
</body>
</html>