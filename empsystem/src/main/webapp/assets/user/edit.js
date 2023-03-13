$(function () {
    if (error) {
        layer.alert(error);
    }

    //重置按钮
    $("#reset-btn").click(function () {
        $(".container")[0].reset();
    });


    $("#submit-btn").click(function () {
        //信息校验
        let username = $(":input[name=username]").val();
        if (username.trim() === "") {
            layer.msg("用户名不能为空")
            return false;
        }

        let password = $(":input[name=password]").val();
        if (password.trim() === "") {
            layer.msg("密码不能为空")
            return false;
        }

        let newpassword = $(":input[name=newpassword]").val();
        if (newpassword.trim() === "") {
            layer.msg("新密码不能为空")
            return false;
        }
        let newpassword2 = $(":input[name=newpassword2]").val();
        if (newpassword2.trim() === "") {
            layer.msg("重复密码不能为空")
            return false;
        }

        let url = ctx + "/user/edit";

        $.post(url, {
            username,
            password,
            newpassword,newpassword2}, function (resp) {
            if (resp.error){
                layer.alert(resp.error);
            }else{
                location.href = ctx + "/user/logout";
            }
        }, "json");

    });
});