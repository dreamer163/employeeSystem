$(function () {
    if (error) {
        layer.alert(error);
    }

    $("#submit-btn").click(function (){
        //校验
        //1.
        let depId = $(":input[name=depId]").val();
        if (depId.trim() === "") {
            layer.msg("部门编号不能为空");
            return false;
        }
        //2.
        let name = $(":input[name=name]").val();
        if (name.trim() === "") {
            layer.msg("部门名称不能为空");
            return false;
        }
        //3.
        let leader = $(":input[name=leader]").val();
        if (leader.trim() === "") {
            layer.msg("部门领导不能为空");
            return false;
        }

        const url = ctx + "/department/edit";

        $.post(url, {
            depId,
            name,
            leader,
        }, function (resp) {
            if (resp.error) {
                layer.alert(resp.error);
            } else {
                location.href = ctx + "/department/list";
            }
        }, "json");
    });
});
