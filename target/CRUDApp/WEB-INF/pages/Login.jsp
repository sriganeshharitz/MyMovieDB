<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/22/2017
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s1"%>
<html>
<head>
    <title>Login</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Brand.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <h5 class="card-header">
                        Login
                    </h5>
                    <div class="card-body">
                        <s1:form action="login" method="post" modelAttribute="loginBean">
                            <div class="form-group">
                                <label for="email">
                                    Email:
                                </label>
                                <s1:input path="email" cssClass="form-control"></s1:input>
                                <s1:errors path="email" cssClass="text-danger"></s1:errors>
                            </div>
                            <div class="form-group">
                                <label for="password">
                                    Password:
                                </label>
                                <s1:password path="password" cssClass="form-control"></s1:password>
                                <s1:errors path="password" cssClass="text-danger"></s1:errors>
                            </div>
                            <p class="text-danger">${msg}</p>
                            <input type="submit" value="Login" class="btn btn-primary btn-block">
                        </s1:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
