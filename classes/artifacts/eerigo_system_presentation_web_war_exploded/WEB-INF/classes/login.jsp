<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理--登录</title>
</head>
<body>
<!--最顶菜单-->
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse"
                    data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="../" class="navbar-brand">Eerigo</a>
        </div>
    </div>
</header>
<!--最顶菜单 end-->

<div class="container bs-docs-container">
    <div class="row">
        <div class="col-md-9">
            <form role="form">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">保存</button>
                <hr>
            </form>
        </div>
    </div>
</div>

</body>
</html>
