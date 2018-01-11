
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>MyMovieDB</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Brand.jsp"%>
    <div class="container">
        <h1 class="display-2">Welcome To MyMovieDB</h1>
        <hr>
        <c:if test="${msg!=null}">
            <div class="p-3 mb-2 bg-success text-white">${msg}</div>
        </c:if>
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="list-group">
                    <a href="Registration" class="list-group-item list-group-item-action text-center">Register</a>
                    <a href="showLogin" class="list-group-item list-group-item-action text-center">Login</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
