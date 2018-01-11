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
    <script defer src="https://use.fontawesome.com/releases/v5.0.2/js/all.js"></script>
</head>
<body>
    <%@include file="Header.jsp"%>
    <div class="container">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading text-center">Hurrayy!!</h4>
            <p class="text-center">${msg}</p>
            <hr>
            <p class="text-center">Found ${watchListsForUser.size()} lists</p>
        </div>
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="list-group">
                    <div class="row">
                        <c:forEach items="${watchListsForUser}" var="watchList">
                            <div class="col-md-8">
                                <a href="viewMoviesOfList?listName=${watchList.name}&listId=${watchList.id}" class="list-group-item list-group-item-action">${watchList.name}</a>
                            </div>
                            <div class="col-md-4">
                                <a href="deleteList?id=${watchList.id}"  class="list-group-item list-group-item-action"><i class="fas fa-trash-alt"></i></a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
