<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/22/2017
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Brand.jsp"%>
    <div class="container">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading text-center">Hurrayy!!</h4>
            <p class="text-center">${msg}</p>
            <hr>
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <a href="showLogin" class="btn btn-success btn-block">Login</a>
                </div>
            </div>

        </div>

    </div>

</body>
</html>
