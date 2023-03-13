$(function () {
    if (error) {
        layer.alert(error);
    }
    //重置按钮
    $("#reset-btn").click(function () {
        $(".container")[0].reset();
    });

    //提交按钮 post请求表单 department/add 传送到后端
    $("#submit-btn").click(function (){
        //校验
        //1.
        let depId = $(":input[name=depId]").val();
        console.log("aa"+depId);
        if (depId.trim() === "") {
            layer.msg("部门编号不能为空");
            return false;
        }
        //2.
        let name = $(":input[name=name]").val();
        if (name.trim() === "") {
            layer.msg("部门名不能为空");
            return false;
        }
        console.log("aa"+name);
        //3.
        let leader =$(":input[name=leader]").val();
        if (leader.trim() === "") {
            layer.msg("部门领导不能为空");
            return false;
        }

        console.log("aa"+leader);
        //通过

        $("#dept-form").submit();

    });
});