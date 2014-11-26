function openwin(url) {
    window.open(url,'newwindow');
}

function selectAll(checkbox) {
    //$('input[type=checkbox]').attr('checked', $(checkbox).attr('checked'));
    var chkvalue = $(checkbox)[0].checked;
    $("input[name='chk_id']").each(function () {
        this.checked = chkvalue;
    });
}