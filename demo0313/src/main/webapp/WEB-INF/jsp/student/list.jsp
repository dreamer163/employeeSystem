<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生列表集合</h1>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>拼音</td>
        <td>性别</td>
        <td>电话</td>
        <td>班级</td>
    </tr>
    <c:forEach items="${students}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.py}</td>
            <td>${stu.sex}</td>
            <td>${stu.phone}</td>
            <td>${stu.classEntity.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
