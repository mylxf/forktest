<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/16
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<form name="requimentLogin" action="country_opt.action?method=addCountry" method="post" id="f_requiment_login">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                    class="sr-only">Close</span></button>
            <h4 class="modal-title" id="myModalLabel">产地添加</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <label>产地</label>
                <input type="text" class="form-control" name="countryName" />
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <input type="submit" class="btn btn-primary" value="保存"/>
        </div>
    </div>
</div>
</form>