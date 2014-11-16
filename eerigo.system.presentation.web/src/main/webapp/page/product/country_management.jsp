<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>产地管理</title>
</head>
<body>
<jsp:include page="/page/header.jsp"/>

<div class="container bs-docs-container">
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
                    <th>产地</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="models" status="index">
                        <tr>
                            <th><input id="chk_<s:property value="id"/>" type="checkbox"/></th>
                            <td><s:property value="id"/></td>
                            <td><s:property value="countryName"/></td>
                            <td>
                                <button id="btnDel_<s:property value="id"/>" type="button" class="btn btn-danger btn-xs">删除</button>
                                <button id="btnEdit_<s:property value="id"/>" type="button" class="btn btn-success btn-xs">编辑</button>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
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
