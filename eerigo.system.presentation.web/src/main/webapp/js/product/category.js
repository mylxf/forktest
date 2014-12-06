/**
 * Created by fengfeng on 14/11/26.
 */
function batchDelCategory() {
    var idlist = "";
    var arrChk = $("input[name='chk_id']:checked");
    $(arrChk).each(function () {
        idlist += this.id.substring(4) + "|";
    });
    //alert(idlist);

    if(idlist!=""){
        $.ajax({
            url: "/category.action?method=batchDelCategory",
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

function f_category_save_submit() {
    var message = "";
    if (newTrim($("#categoryName").val()) == "") {
        message += "请输入类别名称!\n";
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

function f_category_delete(id) {
    $.ajax({
        url: "/category.action?method=deleteCategory",
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