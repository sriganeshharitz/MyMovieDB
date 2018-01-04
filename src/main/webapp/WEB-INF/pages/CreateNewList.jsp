<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/26/2017
  Time: 12:22 PM
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
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="createNewList">
                    <div class="form-group">
                        <label for="watchListName">
                            Enter the name of the list:
                        </label>
                        <input type="text" name="watchListName" class="form-control" id="watchListName">
                        <p class="text-danger">${msg}</p>
                        <input type="submit" value="Create" class="btn btn-success">
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
