/**
 * Created by fengfeng on 14/11/26.
 */
function batchDelCountry() {
    var idlist = "";
    var arrChk = $("input[name='chk_id']:checked");
    $(arrChk).each(function () {
        idlist += this.id.substring(4) + "|";
    });
    //alert(idlist);

    if(idlist!=""){
        $.ajax({
            url: "/country.action?method=batchDelCountry",
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

function f_country_save_submit() {
    var message = "";
    if (newTrim($("#countryName").val()) == "") {
        message += "请输入产地名称!\n";
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

function f_country_delete(id) {
    $.ajax({
        url: "/country.action?method=deleteCountry",
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