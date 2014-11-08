<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/8
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<jsp:include page="/page/header.jsp"/>

<div class="container bs-docs-container">
    <div class="row">
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <jsp:include page="/page/menu.jsp"/>
        <div class="col-md-9">
            <!--正文-->
            <div class="bar-mod clearfix tl">
                <input type="text" class="form-control dib" placeholder="Search">
                <button type="submit" class="btn btn-default">搜索</button>
                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#myModal"><span
                        class="glyphicon glyphicon-plus"></span> 添加</a>
                <a href="#" class="btn btn-danger"><span class="glyphicon"></span>全部删除</a>
            </div>
            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th><input type="checkbox"/></th>
                    <th>#</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th><input type="checkbox"/></th>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-danger btn-xs">Danger</button>
                            <button type="button" class="btn btn-danger btn-xs dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">删除</a></li>
                                <li><a href="#">编辑</a></li>
                                <li class="divider"></li>
                                <li><a href="#">自定义</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox"/></th>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th><input type="checkbox"/></th>
                    <td>3</td>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>
                        <button type="button" class="btn btn-danger btn-xs">删除</button>
                        <button type="button" class="btn btn-success btn-xs">编辑</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <ul class="pagination">
                <li class="disabled"><a href="#">«</a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
            </ul>
            <!--正文 end-->
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
