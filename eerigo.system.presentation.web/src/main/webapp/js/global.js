function openwin(url){
    //window.open(url,'newwindow');
}

function popup(html, title, width, height) {
    jQuery(html).dialog({
        "title" : title,
        "width" : width,
        "height" : height,
        "z-index:":"8888",
        "modal" : true,
        "resizable" : false,
        "dialogClass" : "dialog",
        helper : "clone",
        close: function () {
            $(this).html("");
        }
    });
}

/**
 * 跳转到view页面之前需要加载的数据
 *
 * @param method_parameter
 *            显示页面前加载数据的方法
 * @param div_view_id
 *            弹出div的id
 * @param view_title
 *            弹出div的标题
 */
function common_to_view(method_parameter, div_view_id, view_title, div_width,  div_height) {
    alert("ss");
    var url = method_parameter;
    $("#"+div_view_id).html("");
    popup("#"+div_view_id,view_title,div_width,div_height);
    $.ajax({
        url: url,
        type: 'POST',
        async:false,
        dataType: 'html',
        error: function(){alert('Error');},
        success: function(result){
            //replace_innerHTML(div_view_id, result, 'jsp_view_begin','jsp_view_end');
        }
    });
}