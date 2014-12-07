<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>商品管理</title>
    <script src="${pageContext.request.contextPath}/js/product/product.js"></script>
</head>
<body>
<jsp:include page="/page/header.jsp"/>

<div class="container bs-docs-container">
    <div class="row">
        <jsp:include page="/page/menu.jsp"/>
        <div class="col-md-9">
            <!--正文-->
            <div class="bar-mod clearfix tl">
                <!--<input type="text" class="form-control dib" placeholder="Search">
                <button type="submit" class="btn btn-default">搜索</button>-->
                <a href="#" class="btn btn-success" onclick="open_view('product.action?method=openView');"><span
                        class="glyphicon glyphicon-plus"></span> 添加</a>
                <a href="#" onclick="batchDelProduct();" class="btn btn-danger"><span class="glyphicon"></span>全部删除</a>
            </div>
            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th><input type="checkbox" onclick="selectAll(this);"/></th>
                    <th>商品名称</th>
                    <th>类别</th>
                    <th>品牌</th>
                    <th>产地</th>
                    <th>成本价</th>
                    <th>销售价</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="models" status="index">
                        <tr>
                            <th><input id="chk_<s:property value="id"/>" type="checkbox" name="chk_id" /></th>
                            <td><s:property value="productName"/></td>
                            <td><s:property value="productCategory.categoryName"/></td>
                            <td><s:property value="productBrand.brandName"/></td>
                            <td><s:property value="origin.countryName"/></td>
                            <td><s:property value="costPrice"/></td>
                            <td><s:property value="sellPrice"/></td>
                            <td>
                                <button type="button" class="btn btn-danger btn-xs"
                                        onclick="f_product_delete('<s:property value='id'/>');">删除
                                </button>
                                <input id="btnEdit_<s:property value="id"/>" type="button" class="btn btn-success btn-xs" onclick="open_view('product.action?method=openView&id=<s:property value="id"/>');" value="编辑"/>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <!--<ul class="pagination">
                <li class="disabled"><a href="#">«</a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
            </ul>-->
            <!--正文 end-->
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>
</body>
</html>