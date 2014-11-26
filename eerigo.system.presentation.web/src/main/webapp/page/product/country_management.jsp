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
    <script src="${pageContext.request.contextPath}/js/product/country.js"></script>
</head>
<body>
<jsp:include page="/page/header.jsp"/>

<div class="container bs-docs-container">
    <div class="row">
        <jsp:include page="/page/menu.jsp"/>
        <div class="col-md-9">
            <!--正文-->
            <div class="bar-mod clearfix tl">
                <!--<a href="#" onclick="javascript:common_to_view('/country_opt','dialog-form','产地维护',800,450);" class="btn btn-success"><span
                        class="glyphicon glyphicon-plus"></span>添加</a>-->
                <a href="${pageContext.request.contextPath}/page/product/country_opt.action" class="btn btn-success" target="_blank"><span
                        class="glyphicon glyphicon-plus"></span>添加</a>
                <a href="#" onclick="javascript:batchDelCountry();" class="btn btn-danger"><span class="glyphicon"></span>全部删除</a>
            </div>
            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th><input type="checkbox" onclick="selectAll(this);"/></th>
                    <th>#</th>
                    <th>产地</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="models" status="index">
                        <tr>
                            <th><input id="chk_<s:property value="id"/>" type="checkbox" name="chk_id" /></th>
                            <td><s:property value="id"/></td>
                            <td><s:property value="countryName"/></td>
                            <td>
                                <input id="btnEdit_<s:property value="id"/>" type="button" class="btn btn-success btn-xs" onclick="openwin('${pageContext.request.contextPath}/page/product/country_opt.action?id=<s:property value="id"/>');" value="编辑"/>
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
<div class="modal fade" id="dialog-form" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>

</body>
</html>
