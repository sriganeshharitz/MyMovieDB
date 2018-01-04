<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/27/2017
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Header.jsp"%>
    <h2>${msg}</h2>
    <a href="/searchMovieForList?searchName=${movie.title}&listName=${listName}">Add more movies</a>
    <a href="/showCreateListView">Create a new List</a>
</body>
</html>
