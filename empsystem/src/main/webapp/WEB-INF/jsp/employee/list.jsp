<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${ctx}/">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="assets/employee/css/list.css">
    <script src="assets/lib/jquery/jquery-3.6.3.min.js"></script>
    <script src="assets/lib/layer/layer.js"></script>
    <script src="assets/lib/laydate/laydate.js"></script>
    <script>
        const ctx = "${ctx}";
    </script>

    <script src="assets/employee/js/list.js"></script>
</head>
<body>
<div class="search">
    <form action="" method="post" class="clear">
        <div>
            <label for="emp-id">员工编号</label>
            <input type="text" id="emp-id" placeholder="请输入工号">
        </div>
        <div>
            <label for="name">姓名：</label>
            <input type="text" id="name" placeholder="请输入姓名">
        </div>

        <div>
            <label for="sex">性别：</label>
            <select id="sex">
                <option value="">不限</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div>
            <label for="nativePlace">籍贯：</label>
            <input type="text" id="nativePlace" placeholder="请输入籍贯">
        </div>
        <div>
            <label for="depId">部门编号：</label>
            <input type="text" id="depId" placeholder="输入部门编号">
        </div>
    </form>
</div>
<div class="action clear">
    <div>
        <button id="add-btn">添加</button>
    </div>
    <div>
        <button id="edit-btn">修改</button>
    </div>
    <div>
        <button id="search-btn">查询</button>
    </div>
    <div>
        <button id="del-btn">删除</button>
    </div>
    <div>
        <button id="reset-btn">重置</button>
    </div>
</div>
<div class="display">
    <table id="tbl">
        <thead>
        <tr>
            <th><input type="checkbox" id="check-all"></th>
            <th>员工编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>籍贯</th>
            <th>雇用日期</th>
            <th>部门编号</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
<div class="paginate clear">
    <div class="fl">
        <span>总页数：</span>
        <span id="pages"></span>
        <span>总记录数：</span>
        <span id="total"></span>
        <span id="page-no" style="display: none"></span>
    </div>
    <ul class="clear fl">
        <li class="first"><a href="#">首页</a></li>
        <li class="prev"><a href="#">上一页</a></li>

        <li class="next"><a href="#">下一页</a></li>
        <li class="last"><a href="#">尾页</a></li>
    </ul>
    <select id="page-size" class="fl">
        <option value="8">8</option>
        <option value="10">10</option>
        <option value="30">30</option>
        <option value="40">40</option>
        <option value="50">50</option>
    </select>
</div>
</body>
</html>
