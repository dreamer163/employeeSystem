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
        const sex = "${emps.sex}";
        const ctx = "${ctx}";
    </script>

    <script src="assets/employee/js/add.js"></script>
</head>
<body>

<form id="emp-form" action="employee/edit" method="post">
    <div class="container">
        <h1>添加部门员工信息</h1>
        <div>
            <label for="empId" class="required" >员工编号(*)：</label>
            <input type="text" id="empId"
                   autocomplete="off" name="empId" placeholder="请输入员工编号，不可为空" value="${emps.empId}" readonly>
        </div>
        <div>
            <label for="name" class="required">姓名(*)： </label>
            <input type="text" id="name" name="name" autocomplete="off" placeholder="请输入姓名，不可为空" value="${emps.name}">
        </div>
        <div class="clear sex">
            <label for="" class="fl">性别：</label>
            <div class="fl">
                <input type="radio" id="male" name="sex" value="男" checked>
                <h2>男</h2>
            </div>
            <div class="fl">
                <input type="radio" id="female" name="sex" value="女">
                <h2>女</h2>
            </div>
        </div>
        <div>
            <label for="birthday">出生日期：</label><input type="text" id="birthday" autocomplete="off" name="birthday" value="${emps.birthday}"  >
        </div>
        <div>
            <label for="nativePlace">籍贯： </label><input type="text" id="nativePlace" autocomplete="off" name="nativePlace" value="${emps.nativePlace}">
        </div>
        <div>
            <label for="hireDate">雇佣日期：</label><input type="text" id="hireDate" autocomplete="off" name="hireDate" value="${emps.hiredate}">
        </div>
        <div>
            <label for="depId">所属部门编号：</label><input type="text" id="depId" autocomplete="off" name="depId" value="${emps.depId}">
        </div>
        <div>
            <label for="">部门名称：</label>
            <select name="deptId" id="deptId">

            </select>

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
