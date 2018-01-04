
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s1"%>
<html>
<head>
    <title>Register</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Brand.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <h5 class="card-header">Register</h5>
                    <div class="card-body">
                        <s1:form action="register" modelAttribute="user">
                            <div class="form-group">
                                <label for="firstName">
                                    First Name:
                                </label>
                                <s1:input path="firstName" cssClass="form-control"/>
                                <s1:errors path="firstName" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="lastName">
                                    Last Name:
                                </label>
                                <s1:input path="lastName" cssClass="form-control"/>
                                <s1:errors path="lastName" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="email">
                                    Email:
                                </label>
                                <s1:input path="email" cssClass="form-control"/>
                                <s1:errors path="email" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="password">
                                    Password:
                                </label>
                                <s1:password path="password" cssClass="form-control"/>
                                <s1:errors path="password" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="password">
                                    Confirm Password:
                                </label>
                                <s1:password path="rpassword" cssClass="form-control"/>
                                <s1:errors path="rpassword" cssClass="text-danger"/>
                                <p class="text text-danger">${msg}</p>
                            </div>
                            <input type="submit" class="btn btn-primary">
                        </s1:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
