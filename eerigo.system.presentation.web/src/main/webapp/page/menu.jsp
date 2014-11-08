<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/8
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-3">
    <ul class="nav nav-pills nav-stacked" role="tablist" style="max-width: 300px;">
        <li id="menu_product" role="presentation" class="active">
            <a href="#">商品</a>
            <ul>
                <li><a href="#">分类管理</a></li>
                <li><a href="#">商品管理</a></li>
            </ul>
        </li>
        <li id="menu_order" role="presentation">
            <a href="#">订单</a>
            <ul>
                <li><a href="#">订单管理</a></li>
            </ul>
        </li>
        <li id="menu_user" role="presentation">
            <a href="#">用户</a>
            <ul>
                <li><a href="/page/user/usermanager.jsp">用户管理</a></li>
            </ul>
        </li>
    </ul>
</div>
