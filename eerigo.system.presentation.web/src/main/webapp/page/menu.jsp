<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked" role="tablist" style="max-width: 300px;">
        <li id="menu_website" role="presentation" class="active">
            <a href="#">类别</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/page/product/category_management.jsp">类别管理</a></li>
            </ul>
        </li>
        <li id="menu_brand" role="presentation">
            <a href="#">品牌</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/page/product/brand_management.jsp">品牌管理</a></li>
            </ul>
        </li>
        <li id="menu_product" role="presentation">
            <a href="#">商品</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/page/product/product_management.jsp">商品管理</a></li>
            </ul>
        </li>
    </ul>
</div>
