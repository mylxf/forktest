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
            replace_innerHTML(div_view_id, result, 'jsp_view_begin','jsp_view_end');
        }
    });
}


function common_to_submit(logo){
    $("#f_common_submit").ajaxForm({
        type : "POST",
        dataType : "html", // JSON
        resetForm : false,// 表单提交成功是否进行重置。
        error : function(result) {
            alert(result);
        },
        success : function(data) {
            //如果有错误信息，则输出错误信息
            show_error_msg(data);
            if(newTrim(data) == "alert_begin保存失败,Name已存在alert_end"){
                return false;
            }
            $("#div_f_view").dialog("close");
            // 成功之后刷新父窗口
            //common_f_list_submit();
            if(logo == "producer")
                menu_redirect_selected("producer.action","100993");
            else
                menu_redirect_selected("consumer.action","100994");
        }
    }).submit();
}

/**
 * list表单提交方法
 */
function common_f_list_submit() {
    $("#f_list").ajaxForm({
        cache : false,
        type : "POST",
        dataType : "html", // JSON
        resetForm : true,// 表单提交成功是否进行重置。
        error : function(result) {
            alert("common_f_list_submit error");
        },
        success : function(result) {
            // 成功之后刷新父窗口
            replace_innerHTML('jsp_content', result, 'jsp_child_begin', 'jsp_child_end');
        },
        beforeSubmit : function(a, f, o) {
        }
    }).submit();
}