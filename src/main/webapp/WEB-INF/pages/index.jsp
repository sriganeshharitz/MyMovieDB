
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
        <ul>
            <li><a href="Registration">Register</a></li>
            <li><a href="showLogin">Login</a></li>
        </ul>
    </div>
</body>
</html>
