<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/29/2017
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s1"%>
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
                <div class="card">
                    <h5 class="card-header">
                        Share ${listName} with Friends!
                    </h5>
                    <div class="card-body">
                        <s1:form action="share" modelAttribute="emailBean" method="post">
                            <div class="form-group">
                                <label for="emails">
                                    Enter emails separated by comma:
                                </label>
                                <s1:textarea path="emails" cssClass="form-control"/><s1:errors path="emails"/>
                            </div>
                            <div class="form-group">
                                <label for="subject">
                                    Subject:
                                </label>
                                <s1:input path="subject" cssClass="form-control"/><s1:errors path="subject"/>
                            </div>
                            <div class="form-group">
                                <label for="body">
                                    Body
                                </label>
                                <s1:textarea path="body" cssClass="form-control"/><s1:errors path="body"/>
                            </div>
                            <input type="text" value="${listName}" name="listName" hidden>
                            <input type="submit" value="Share" class="btn btn-primary btn-block">
                        </s1:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
