/**
 * Created by fengfeng on 14/12/6.
 */
/**
 * Created by fengfeng on 14/11/26.
 */
function batchDelProduct() {
    var idlist = "";
    var arrChk = $("input[name='chk_id']:checked");
    $(arrChk).each(function () {
        idlist += this.id.substring(4) + "|";
    });
    //alert(idlist);

    if(idlist!=""){
        $.ajax({
            url: "/product.action?method=batchDelProduct",
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

function f_product_save_submit() {
    var message = "";
    if (newTrim($("#productName").val()) == "") {
        message += "请输入商品名称!\n";
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

function f_product_delete(id) {
    $.ajax({
        url: "/product.action?method=deleteProduct",
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

function f_product_property_save_submit() {
    var message = "";

    if (message != "") {
        alert(message);
    } else {
        $("#f_common_submit").ajaxSubmit(function (data) {
            $("#close").click();
            location.reload()
        });
    }
}