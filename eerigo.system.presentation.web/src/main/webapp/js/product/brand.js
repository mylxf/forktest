function f_brand_save_submit() {
    var message = "";
    if (newTrim($("#brandName").val()) == "") {
        message += "请输入品牌名称!\n";
    }

    if (message != "") {
        alert(message);
    } else {
        $("#f_common_submit").ajaxSubmit(function (data) {
            $("#close").click();
            location.reload()
        });
    }
}

function f_brand_delete(id) {
    $.ajax({
        url: "brand.action?method=deleteBrand",
        data: {'id': id},
        type: 'post',
        dataType: 'json',
        success: function (result) {
            location.reload();
        }
    });
}