<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/28/2017
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Header.jsp"%>
    <h2>Found ${watchListsForUser.size()} lists</h2>
    <ul>
        <c:forEach items="${watchListsForUser}" var="watchList">
            <li><a href="viewMoviesOfList?listName=${watchList.name}&listId=${watchList.id}">${watchList.name}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
