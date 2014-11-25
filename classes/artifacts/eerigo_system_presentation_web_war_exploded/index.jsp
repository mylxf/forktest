<%--
  Created by IntelliJ IDEA.
  User: fengfeng
  Date: 14/11/8
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<jsp:include page="/page/header.jsp"/>

<div class="container bs-docs-container">
    <div class="row">
        <jsp:include page="/page/menu.jsp"/>
        <div class="col-md-9">
            <!--正文-->
            <div class="alert alert-success" role="alert">
                <strong>欢迎，柳岩的球迷</strong> <br>您上次登录的ip为<span>192.168.7.115</span>
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/100%x200" alt="100%x200"
                             src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNDIiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSIvPjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjEyMSIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE1cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MjQyeDIwMDwvdGV4dD48L3N2Zz4="
                             style="height: 200px; width: 100%; display: block;">

                        <div class="caption">
                            <h3>快捷方式1</h3>

                            <p>Cras justo odio</p>

                            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#"
                                                                                               class="btn btn-default"
                                                                                               role="button">Button</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/100%x200" alt="100%x200"
                             src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNDIiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSIvPjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjEyMSIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE1cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MjQyeDIwMDwvdGV4dD48L3N2Zz4="
                             style="height: 200px; width: 100%; display: block;">

                        <div class="caption">
                            <h3>快捷方式2</h3>

                            <p>Cras justo odio</p>

                            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#"
                                                                                               class="btn btn-default"
                                                                                               role="button">Button</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img data-src="holder.js/100%x200" alt="100%x200"
                             src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNDIiIGhlaWdodD0iMjAwIj48cmVjdCB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI2VlZSIvPjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjEyMSIgeT0iMTAwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjE1cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MjQyeDIwMDwvdGV4dD48L3N2Zz4="
                             style="height: 200px; width: 100%; display: block;">

                        <div class="caption">
                            <h3>快捷方式3</h3>

                            <p>Cras justo odio</p>

                            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#"
                                                                                               class="btn btn-default"
                                                                                               role="button">Button</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

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
