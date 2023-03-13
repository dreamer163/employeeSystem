$(function () {
    if (error) {
        layer.alert(error);
    }
    if (sex) {
        $(":radio[name=sex][value="+sex+"]").prop("checked",true);
    }
    laydate.render({
        elem: "#birthday"
    });
    laydate.render({
        elem: "#hireDate"
    });

    //重置按钮
    $("#reset-btn").click(function () {
        $(".container")[0].reset();
    });
    //获取部门信息
    fetchDept();


    //提交按钮 post请求表单 employee/add 传送到后端
    $("#submit-btn").click(function (){
        //校验
        //1.
        let empId = $(":input[name=empId]").val();
        if (empId.trim() === "") {
            layer.msg("员工编号不能为空");
            return false;
        }
        //2.
        let name = $(":input[name=name]").val();
        if (name.trim() === "") {
            layer.msg("姓名不能为空");
            return false;
        }
        //3.
        let sex = $(":input[name=sex]:checked").val();
        if ("男" !== sex && "女" !== sex) {
            layer.msg("性别必须为男或女");
            return false;
        }
        //4.
        let birthday = $(":input[name=birthday]").val();
        let regex = /\d{4}-\d{2}-\d{2}/;
        if (!birthday.match(regex)) {
            layer.msg("出生日期格式不正确");
            return false;
        }

        //5.
        let nativePlace =$(":input[name=nativePlace]").val();
        if (nativePlace.trim() === "") {
            layer.msg("籍贯不能为空");
            return false;
        }
        //6.
        let hireDate = $(":input[name=hireDate]").val();
        let regex2 = /\d{4}-\d{2}-\d{2}/;
        if (!hireDate.match(regex2)) {
            layer.msg("雇佣日期格式不正确");
            return false;
        }

        //7.
        let depId =$(":input[name=depId]").val();
        if (depId.trim() === "") {
            layer.msg("部门编号不能为空");
            return false;
        }
        //通过
        $("#emp-form").submit();

    });
});
function fetchDept() {
    const url = ctx + "/department/combolist"
    $.post(url, {}, function (resp) {
        if (resp.success) {
            let data = resp.data;
            $("#deptId").empty();
            data.forEach(function (item) {
                $("#deptId").append($("<option value='" + item.depId + "'>" + item.name + "</option>"))
            });
        }
    }, "json");
}