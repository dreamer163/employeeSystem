$(function () {
    $(".nav:not(#index)").on("click", "li>a", function (e) {
        e.preventDefault();//阻止超链接的默认行为
        let val = $(this).attr("href");
        $(".main>iframe").attr("src", val);
    });

    $("#index").click(function (){
        location.href = ctx +"/index";
    });


    //点击修改个人信息，layer弹窗
    $(".logout>a:first-child").click(function () {
        layer.open({
            type: 2,
            title: '修改用户信息',
            shadeClose: true,
            shade: false,
            area: ['650px', '600px'],
            content: ctx + '/user/edit'
        });
    });
    //退出
    $(".logout>a:last-child").click(function (e) {
        e.preventDefault();
        location.href = ctx + "/user/logout";
    });


});