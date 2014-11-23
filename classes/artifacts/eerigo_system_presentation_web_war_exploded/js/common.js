/**
 * 弹出div
 *
 * @param html
 *            div内容
 * @param title
 *            div标题
 * @param width
 *            div宽度
 * @param height
 *            div高度
 * @param zIndex
 *            div层叠
 */
function popup(html, title, width, height) {
    jQuery(html).dialog({
        "title": title,
        "width": width,
        "height": height,
        "z-index:": "8888",
        "modal": true,
        "resizable": false,
        "dialogClass": "dialog",
        helper: "clone",
        close: function () {
            $(this).html("");
        }
    });
}

/**
 * div隐藏
 * @param div_view_id
 */
function close_div(div_view_id) {
    $("#" + div_view_id).dialog("close");
}

/**
 * 截取html代码中的一段付给一个元素
 *
 * @param obj_id
 * @param html_value
 * @param begin_html
 * @param end_html
 */
function replace_innerHTML(obj_id, html_value, begin_html, end_html, dom_id) {
    if (html_value != null && html_value != '') {
        var begin = html_value.indexOf(begin_html) + begin_html.length;
        var end = html_value.indexOf(end_html);
        if (begin != '' && end != '' && end > begin) {
            var temp_value = html_value.substring(begin, end);
            temp_value = temp_value.replace("pop_up", "normal");
            document.getElementById(obj_id).innerHTML = temp_value;
        } else {
            document.getElementById(obj_id).innerHTML = html_value;
        }
        if (null != dom_id && $("#" + dom_id) != null) {
            $("#" + dom_id).trigger("click");
        }
        f_tablerow_color();
    }
}

/**
 * 读取错误信息
 * @param html_value
 * @param begin_html
 * @param end_html
 */
function show_error_msg(html_value) {
    if (html_value != null && html_value.indexOf('alert_begin') != -1) {
        var begin = html_value.indexOf('alert_begin') + 11;
        var end = html_value.indexOf('alert_end');
        if (begin != '' && end != '' && end > begin) {
            var error = html_value.substring(begin, end);
            alert(error);
        }
    }
}

/**
 * 全选、反选
 * @param str
 */
function checkAll(str) {
    if (str == 'is_query_tasklist') {
        var a = document.getElementsByName(str);
        var n = a.length;
        for (var i = 0; i < n; i++) {
            if (a[i].disabled != true) {
                a[i].checked = window.event.srcElement.checked;
            }
        }

    } else {
        var a = document.getElementsByName(str);
        var n = a.length;
        for (var i = 0; i < n; i++) {
            a[i].checked = window.event.srcElement.checked;
        }
    }
}

/**
 * 直接跳转jsp页面
 * @param url
 * @param app_id
 */
function open_window(url, app_id) {
    window.open(url, app_id, "width=" +
    (screen.width - 5) + ",height=" +
    (screen.height - 30) +
    ",top=0,left=0,,toolbar=yes, menubar=yes, scrollbars=yes,resizable=yes,location=yes, status=yes");
}


/**
 * 设置 刷新图标  alt模拟
 * @param my
 * @param show_flag
 */
function div_alts(my, show_flag) {
    if (show_flag == 'div_set') {
        my.title = "设置";
    } else if (show_flag == 'div_refresh') {
        my.title = "刷新";
    }
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
function to_view_with_formId(formId, method_parameter, div_view_id, view_title, div_width,
                             div_height) {
    var url = method_parameter;
    $("#" + div_view_id).html("");
    popup("#" + div_view_id, view_title, div_width, div_height);
    $.ajax({
        url: url,
        type: 'POST',
        async: true,
        dataType: 'html',
        error: function () {
            alert('Error');
        },
        success: function (result) {
            replace_innerHTML(div_view_id, result, 'jsp_view_begin', 'jsp_view_end');
        }
    });
}

/**
 * 简使用
 * @param method_parameter
 * @param data
 * @param obj_id
 * @param begin_html
 * @param end_html
 */
function common_url_redirect1(method_parameter, data, obj_id, begin_html, end_html) {
    var url = method_parameter;
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        async: true,
        dataType: 'html',
        error: function () {
            alert('Error');
        },
        success: function (result) {
            replace_innerHTML(obj_id, result, begin_html, end_html);
        }
    });
}

/**
 * 动态显示当前的时间
 */
function ShowTime() {
    var myDate = new Date();
    var Today = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
    var Years = myDate.getFullYear();
    var Months = myDate.getMonth() + 1;
    var Dates = myDate.getDate();
    var Days = Today[myDate.getDay()];
    var Hours = myDate.getHours();
    var Minutes = myDate.getMinutes();

    if (Hours < 12) {
        //document.getElementById('greeting').innerText='早上好';
    } else if (Hours < 18) {
        //document.getElementById('greeting').innerText='下午好';
    } else {
        //document.getElementById('greeting').innerText='晚上好';
    }

    Months = Months < 10 ? '0' + Months : Months;
    Dates = Dates < 10 ? '0' + Dates : Dates;

    Hours = Hours < 10 ? '0' + Hours : Hours;
    Minutes = Minutes < 10 ? '0' + Minutes : Minutes;

    document.getElementById('curTime').innerText = Years + '年' + Months + '月' + Dates + '日' + ' ' + Days;
    //每隔半分钟重新调用GetTime函数
    setTimeout("ShowTime()", "30000");
}


function OpenFaqbgDiv(msg) {
    var str = '<div ><table class="dgMain" height="160px" width="320px"><tr class="dgMain_Head"><th>用户提示</th></tr><tr><td style="text-align: center"><img src="/portalAdmin/images/t_wait.gif" />' + msg + '</tr></td></table></div>';
    $(".form").html(str);
    $("#faqbg").css({display: "block", height: $(document).height()});
    $("#faqdiv").css("top", "400px");
    $("#faqdiv").css("display", "block");
    document.documentElement.scrollTop = 0;
}

function closeFaqbgDiv() {
    $("#faqbg").css("display", "none");
    $("#faqdiv").css("display", "none");
}

/**
 * 点击表格变色
 */
var tableRowToggleClasses = new Array('f1', 'f2');
var tableRowClass = 'marked';
var p_row = null;
function f_tablerow_color() {
    $(".dgMain tr").each(function (i, row) {
        $.each(tableRowToggleClasses, function (j, tableRowToggleClasses) {
            if ($(row).hasClass(tableRowToggleClasses)) {
                $(row).click(function () {
                    $(p_row).removeClass(tableRowClass);
                    $(this).addClass(tableRowClass);
                    p_row = this;
                });
            }
        });
    });
}

/**
 * 按钮不可用
 * @param t 按钮对象
 */
function notShowInThis(t) {
    $(t).attr("class", "input_button_2");
    $(t).attr("disabled", "disabled");
}

/**
 * 按钮可用
 * @param t
 */
function isShowInThis(t) {
    $(t).attr("class", "input_button_1");
    $(t).removeAttr("disabled");
}

/**
 * 按钮不可用
 * @param id 按钮id
 */
function notShowInId(id) {
    $("#" + id).attr("class", "input_button_2");
    $("#" + id).attr("disabled", "disabled");
}

function isShowInId(id) {
    $("#" + id).attr("class", "input_button_1");
    $("#" + id).removeAttr("disabled");
}

function newTrim(value) {
    return value.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}