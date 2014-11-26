/**
 * Created by fengfeng on 14/11/26.
 */
function batchDelCategory() {
    var idlist = "";
    var arrChk = $("input[name='chk_id']:checked");
    $(arrChk).each(function () {
        idlist += this.id.substring(4) + "|";
    });
    alert(idlist);

    if(idlist!=""){
        $.ajax({
            url: "/category_opt.action?method=batchDelCategory",
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