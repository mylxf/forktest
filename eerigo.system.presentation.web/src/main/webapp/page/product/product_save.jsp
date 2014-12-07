<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="product.action?method=saveProduct" method="post" id="f_common_submit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">商品编辑</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>名称</label>
                    <input type="text" class="form-control" id="productName" name="model.productName"
                           value="<s:property value='model.productName'/>"/>
                </div>
                <div class="form-group">
                    <label>类别</label>
                    <s:select theme="simple" cssClass="form-control" list="categoryModels" name="model.productCategoryId" listKey="id" listValue="categoryName" value="model.productCategoryId"/>
                </div>
                <div class="form-group">
                    <label>品牌</label>
                    <s:select theme="simple" cssClass="form-control" list="brandModels" name="model.productBrandId" listKey="id" listValue="brandName" value="model.productBrandId"/>
                </div>
                <div class="form-group">
                    <label>产地</label>
                    <s:select theme="simple" cssClass="form-control" list="countryModels" name="model.countryId" listKey="id" listValue="countryName" value="model.countryId"/>
                </div>
                <div class="form-group">
                    <label>描述</label>
                    <textarea class="form-control" id="productDesc" name="model.productDesc" rows="4"><s:property
                            value='model.productDesc'/></textarea>
                </div>
                <div class="form-group">
                    <label>成本价</label>
                    <input type="text" class="form-control" id="costPrice" name="model.costPrice"
                           value="<s:property value='model.costPrice'/>"/>
                </div>
                <div class="form-group">
                    <label>出售价</label>
                    <input type="text" class="form-control" id="sellPrice" name="model.sellPrice"
                           value="<s:property value='model.sellPrice'/>"/>
                </div>
                <div class="form-group">
                    <label>商品重量</label>
                    <input type="text" class="form-control" id="weight" name="model.weight"
                           value="<s:property value='model.weight'/>"/>
                </div>
            </div>
            <div class="modal-footer">
                <input id="hiddenCountryId" name="model.id" type="hidden" value="<s:property value='model.id'/>"/>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="close">关闭</button>
                <input type="button" class="btn btn-primary" onclick="f_product_save_submit();" value="保存"/>
            </div>
        </div>
    </div>
</s:form>