$(function () {
    if (error) {
        layer.alert(error);
    }

    //失去焦点自动检验
    $("#username").blur(function () {
        let username =$("#username").val();
        let result = validateUsername(username);
        if (result!==true){
            layer.msg(result);
        }
    });

    $("#password").blur(function () {
        let password =$("#password").val();

        let result = validatePassword(password);
        if (result!==true){
            layer.msg(result);
        }
    });


    $("#login-btn").click(function () {
        //校验
        let username = $("#username").val();
        let password = $("#password").val();

        let result = validateUsername(username);
        if (result !== true) {
            layer.msg(result);
            return false;
        }
        result = validatePassword(password);
        if (result !== true) {
            layer.msg(result);
            return false;
        }


        $("#login-form").submit();
    });


    $("#captcha").click(function () {
        $(this).attr("src", ctx + "/user/captcha?k=" + new Date().getTime());
    });

    // $("")
});

//用户名格式
function validateUsername(username) {
    let regex = /^\w+@\w+\.\w+$/;
    if (!username.match(regex)) {
        return "用户名必须符合邮箱格式！";
    }
    return true;
}

//密码格式
function validatePassword(password) {
    let regex = /^\w{6,12}$/;
    if (!password.match(regex)) {
        return "密码必须介于6~12位之间";
    }

    regex = /[a-z]+/;
    if (!password.match(regex)) {
        return "密码必须包含至少一个小写字母！";
    }
    regex = /[A-Z]+/;
    if (!password.match(regex)) {
        return "密码必须包含至少一个大写字母！";
    }

    regex = /[0-9]+/;
    if (!password.match(regex)) {
        return "密码必须包含至少一个数字！";
    }
    return true;
}