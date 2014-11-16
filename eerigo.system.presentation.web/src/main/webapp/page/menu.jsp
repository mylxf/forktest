<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked" role="tablist" style="max-width: 300px;">
        <li id="menu_product" role="presentation" class="active">
            <a href="#">商品管理</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/page/product/category_management.jsp">类别管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/product/brand_management.jsp">品牌管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/product/country_management.jsp">产地管理</a></li>
                <li><a href="${pageContext.request.contextPath}/page/product/product_management.jsp">商品管理</a></li>
            </ul>
        </li>
        <li id="menu_order" role="presentation">
            <a href="#">订单管理</a>
            <ul>
                <li><a href="#">订单管理</a></li>
            </ul>
        </li>
        <li id="menu_msg" role="presentation">
            <a href="#">消息管理</a>
            <ul>
                <li><a href="#">站内短消息</a></li>
                <li><a href="#">邮件管理</a></li>
            </ul>
        </li>
        <li id="menu_user" role="presentation">
            <a href="#">用户管理</a>
            <ul>
                <li><a href="#">用户管理</a></li>
            </ul>
        </li>
        <li id="menu_report" role="presentation">
            <a href="#">报表</a>
            <ul>
                <li><a href="#">月度统计报表</a></li>
            </ul>
        </li>
        <li id="menu_system" role="presentation">
            <a href="#">系统管理</a>
            <ul>
                <li><a href="#">日志查询</a></li>
                <li><a href="#">支付接口维护</a></li>
            </ul>
        </li>
    </ul>
</div>
