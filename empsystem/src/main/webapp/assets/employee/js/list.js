$(function () {
    //1.分页事件
    $(".paginate>ul").on("click", "li", function (e) {
        e.preventDefault();//取消默认行为
        let val = $(this).text().trim();//页码
        let ps = parseInt($("#page-size").val());//页面大小
        let pageNo = parseInt($("#page-no").text());
        let pages = parseInt($("#pages").text());

        if ($(this).hasClass("first")) {//首页
            search(1, ps);
        } else if ($(this).hasClass("last")) {//尾页
            search(pages, ps);
        } else if ($(this).hasClass("prev")) {//上一页
            pageNo--;
            if (pageNo < 1) {
                pageNo = 1;
            }
            search(pageNo, ps);
        } else if ($(this).is(".next")) {//下一页
            pageNo++;
            if (pageNo > pages) {
                pageNo = pages;
            }
            search(pageNo, ps);
        } else {//数字页码
            search(parseInt(val), ps);
        }
    });


    //2.查询按钮事件
    $("#search-btn").click(function () {
        let ps = parseInt($("#page-size").val());//页面大小
        search(1, ps);
    });

    $("#search-btn").trigger("click");


    //3.重置按钮
    $("#reset-btn").click(function () {
        $(".search>form")[0].reset();
    });

    //4.添加
    $("#add-btn").click(function () {
        location.href = ctx + "/employee/add";
    });
    //5.删除
    $("#del-btn").click(function () {
        let $selected = $("#tbl>tbody>tr>td:first-child>:checked");
        if ($selected.length === 0) {
            layer.msg("请选中您要删除的记录");

        } else {
            let empIds = [];
            $selected.each(function () {
                let empId = $(this).closest("tr").children().eq(1).text();
                //console.log(empId);
                empIds.push(empId);
            });

            if (empIds.length > 0) {
                layer.confirm("是否确认删除", function () {
                    delByIds();
                });
            }

            function delByIds() {
                let url = ctx + "/employee/delete";
                $.ajax(url ,{
                    method:"post",
                    data:{
                        empIds
                    },dataType:"json",
                    traditional:true,
                    success:function (resp){
                        if(resp.success){
                            layer.msg(resp.msg||"删除成功");
                            location.reload();
                        }else{
                            layer.alert(resp.error()||"删除失败，请稍后再试");
                        }
                    },
                    error:function (resp){
                        layer.alert(resp.error||"删除失败，请稍后再试");
                    }

                });
            }
        }
    });


    //6.修改
    $("#edit-btn").click(function () {
        let $chs = $("#tbl>tbody>tr>td:first-child>:checked");
        if ($chs.length === 0) {
            layer.msg("请选中您要修改的记录");
        } else if ($chs.length > 1) {
            layer.msg("您一次只能选中一行进行修改");
        } else {
            let empId = $chs.closest("tr").children().eq(1).text();
            location.href = ctx + "/employee/edit?empId=" + empId;
        }
    });

    //7.日期插件
    laydate.render({
        elem: "#birthday-from"
    });

    laydate.render({
        elem: "#birthday-to"
    });

    //8.全选与取消全选
    $("#tbl #check-all").click(function () {
        let checked = $(this).prop("checked");
        $("#tbl tbody>tr>td:first-child>:checkbox").prop("checked", checked);
    });

    //9.行选中事件
    $("#tbl>tbody").on("click", "tr>td:not(:first-child)", function () {
        let $tr = $(this).parent();
        let $ch = $tr.children().eq(0).children();
        $ch.prop("checked", !$ch.prop("checked"));
    });

});

//10.查询列表
function search(pageNo = 1, pageSize = 10) {
    let empId = $(".search #emp-id").val();
    let name = $(".search #name").val();
    let sex = $(".search #sex").val();
    let nativePlace = $(".search #nativePlace").val();
    let depId = $(".search #depId").val();
    let data = {
        pageNo,
        pageSize
    };
    if (empId.trim() !== "") {
        data.empId = empId;
    }
    if (name.trim() !== "") {
        data.name = name;
    }
    if (sex.trim() !== "") {
        data.sex = sex;
    }
    if (nativePlace.trim() !== "") {
        data.nativePlace = nativePlace;
    }
    if (depId.trim() !== "") {
        data.depId = depId;
    }

    //代表发送一个ajax请求
    let url = ctx + "/employee/list";//请求地址
    $.post(url, data, function (resp) {
        if (resp.error) {
            layer.alert(resp.error);
            return false;
        }

        let rows = resp.emps;
        let pi = resp.pi;

        $("#pages").text(pi.pages);
        $("#total").text(pi.count);
        $("#page-no").text(pi.pageNo);

        //回调。当请求响应完成，即调用此回调函数

        $("#tbl>tbody").empty();
        for (let i = 0; i < rows.length; i++) {
            let emp = rows[i];
            let $tr = $("<tr>");
            $tr.append($("<td><input type='checkbox'></td>"));
            $tr.append($("<td>" + emp.empId + "</td>"));
            $tr.append($("<td>" + emp.name + "</td>"));
            $tr.append($("<td>" + emp.sex + "</td>"));
            $tr.append($("<td>" + emp.birthday + "</td>"));
            $tr.append($("<td>" + emp.nativePlace + "</td>"));
            $tr.append($("<td>" + emp.hiredate + "</td>"));
            $tr.append($("<td>" + emp.depId + "</td>"));

            $("#tbl>tbody").append($tr);
        }

        //更新页码条
        let navFirst = pi.navFirst;
        let navLast = pi.navLast;
        $(".paginate>ul>li:not(.first):not(.last):not(.prev):not(.next)").remove();

        for (let i = navFirst; i <= navLast; i++) {
            let $li = $("<li><a href='#'>" + i + "</a></li>");
            if (i === pi.pageNo) {
                $li.addClass("active");
            }
            $(".paginate li.next").before($li);
        }

    }, "json");
}