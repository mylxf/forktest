<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/16
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="country.action?method=saveCountry" method="post" id="f_common_submit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">产地编辑</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>产地</label>
                    <input type="text" class="form-control" id="countryName" name="model.countryName"
                           value="<s:property value='model.countryName'/>"/>
                </div>
            </div>
            <div class="modal-footer">
                <input id="hiddenCountryId" name="model.id" type="hidden" value="<s:property value='model.id'/>"/>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="close">关闭</button>
                <input type="button" class="btn btn-primary" onclick="f_country_save_submit()" value="保存"/>
            </div>
        </div>
    </div>
</s:form>