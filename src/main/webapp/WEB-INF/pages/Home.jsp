<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/26/2017
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Header.jsp"%>
    <h2>Welcome ${user.firstName}</h2>
    <hr>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="list-group">
                    <a href="showCreateListView" class="list-group-item list-group-item-action">Create a new WatchList</a>
                    <a href="viewCreatedLists" class="list-group-item list-group-item-action">View Created Lists</a>
                    <a href="#" class="list-group-item list-group-item-action">Share with friends</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
