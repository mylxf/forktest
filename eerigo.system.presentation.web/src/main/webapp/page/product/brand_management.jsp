<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>品牌管理</title>
</head>
<body>
<jsp:include page="/page/header.jsp"/>
<script src="${pageContext.request.contextPath}/js/product/brand.js"></script>
<div class="container bs-docs-container">
    <div class="row">
        <jsp:include page="/page/menu.jsp"/>
        <div class="col-md-9">
            <div class="bar-mod clearfix tl">
                <input type="text" class="form-control dib" placeholder="Search">
                <button type="submit" class="btn btn-default">搜索</button>
                <a href="#" class="btn btn-success" onclick="open_view('brand.action?method=openView')"><span
                        class="glyphicon glyphicon-plus"></span>添加</a>
                <a href="#" class="btn btn-danger"><span class="glyphicon"></span> 全部删除</a>
            </div>
            <s:form action="brand_management" method="post">
                <table class="table table-striped table-condensed">
                    <thead>
                    <tr>
                        <th><input type="checkbox"/></th>
                        <th>#</th>
                        <th>品牌名称</th>
                        <th>品牌LOGO</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="models">
                        <tr>
                            <th><input type="checkbox"/></th>
                            <td><s:property value='id'/></td>
                            <td><s:property value='brandName'/></td>
                            <td><s:property value='brandLogo'/></td>
                            <td>
                                <button type="button" class="btn btn-danger btn-xs"
                                        onclick="f_brand_delete('<s:property value='id'/>')">删除
                                </button>
                                <button type="button" class="btn btn-success btn-xs"
                                        onclick="open_view('brand.action?method=openView&id=<s:property value="id"/>')">
                                    编辑
                                </button>
                            </td>
                        </tr>
                    </s:iterator>
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
            </s:form>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true"></div>
</body>
</html>