<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/22/2017
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Brand.jsp"%>
    <div class="container">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">Dang! :(</h4>
            <p>${msg}</p>
            <hr>
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <a href="home" class="btn btn-danger">Home</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
