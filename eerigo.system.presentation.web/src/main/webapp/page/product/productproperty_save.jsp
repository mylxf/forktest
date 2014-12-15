<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/12/15
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="product.action?method=saveProductProperty" method="post" id="f_common_submit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">商品属性编辑</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>属性名称</label>
                    <input type="text" class="form-control" id="weight" name="model.weight"
                           value="<s:property value='model.weight'/>"/>
                </div>
            </div>
            <div class="modal-footer">
                <input id="hiddenCountryId" name="model.id" type="hidden" value="<s:property value='model.id'/>"/>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="close">关闭</button>
                <input type="button" class="btn btn-primary" onclick="f_product_property_save_submit();" value="保存"/>
            </div>
        </div>
    </div>
</s:form>