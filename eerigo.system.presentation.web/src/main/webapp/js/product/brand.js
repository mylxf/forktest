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
        url: "/brand.action?method=deleteBrand",
        data: "id=" + id,
        type: 'POST',
        async:false,
        dataType: 'html',
        error: function(){alert('Error');},
        success: function (result) {
            window.location.reload();
        }
    });
}

function batchDelBrand() {
    var idlist = "";
    var arrChk = $("input[name='chk_id']:checked");
    $(arrChk).each(function () {
        idlist += this.id.substring(4) + "|";
    });
    //alert(idlist);

    if(idlist!=""){
        $.ajax({
            url: "/brand.action?method=batchDelBrand",
            type: 'POST',
            async:false,
            data: "id_list="+idlist,
            dataType: 'html',
            error: function(){alert('Error');},
            success: function(result){
                window.location.reload();
            }
        });
    }
}