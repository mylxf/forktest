<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>类别管理</title>
    <script src="${pageContext.request.contextPath}/js/product/category.js"></script>
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
                <a href="#" class="btn btn-success" onclick="open_view('category.action?method=openView');"><span
                        class="glyphicon glyphicon-plus"></span> 添加</a>
                <a href="#" onclick="batchDelCategory();" class="btn btn-danger"><span class="glyphicon"></span>全部删除</a>
            </div>
            <table class="table table-striped table-condensed">
                <thead>
                <tr>
                    <th><input type="checkbox" onclick="selectAll(this);"/></th>
                    <th>#</th>
                    <th>类别名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <s:iterator value="models" status="index">
                        <tr>
                            <th><input id="chk_<s:property value="id"/>" type="checkbox" name="chk_id" /></th>
                            <td><s:property value="id"/></td>
                            <td><s:property value="categoryName"/></td>
                            <td>
                                <button type="button" class="btn btn-danger btn-xs"
                                        onclick="f_category_delete('<s:property value='id'/>')";>删除
                                </button>
                                <button id="btnEdit_<s:property value="id"/>" onclick="open_view('category.action?method=openView&id=<s:property value="id"/>');" type="button" class="btn btn-success btn-xs">编辑</button>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            <ul class="pagination">
                <s:url id="firstPage" action='category_management'>
                    <s:param name='index'>1</s:param>
                </s:url>
                <li><s:a href="%{firstPage}" class="">首页</s:a></li>

                <s:url id="prePage" action='category_management'>
                    <s:param name='index'><s:property value='preIndex'/></s:param>
                </s:url>
                <li><s:a href="%{prePage}" class="">上一页</s:a></li>

                <s:url id="nextPage" action='category_management'>
                    <s:param name='index'><s:property value='nextIndex'/></s:param>
                </s:url>
                <li><s:a href="%{nextPage}" class="">下一页</s:a></li>

                <s:url id="lastPage" action='category_management'>
                    <s:param name='index'><s:property value='lastIndex'/></s:param>
                </s:url>
                <li><s:a href="%{lastPage}" class="">尾页</s:a></li>

                <!--<li class="disabled"><a href="#">«</a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>-->
            </ul>
            <!--正文 end-->
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>
</body>
</html>