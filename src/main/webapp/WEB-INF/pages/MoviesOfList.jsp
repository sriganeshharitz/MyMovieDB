<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/28/2017
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s1" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <%@include file="BootStrapCDN.jsp"%>
</head>
<body>
    <%@include file="Header.jsp"%>
    <h2>Found ${watchList.movies.size()} movies in ${watchList.name}</h2>
    <a href="showShareView?listName=${listName}">Share this list with friends!</a>
    <div class="container">
        <div class="row">
            <c:forEach items="${watchList.movies}" var="movie">
                <div class="col-md-4">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">${movie.title}</h4>
                            <p>${movie.release_date}</p>
                            <p>My Review: ${movie.user_review}</p>
                            <%--<p class="card-text">${.overview}</p>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <h5 class="card-header">
                        Add your comment
                    </h5>
                    <div class="card-body">
                        <s1:form action="addComment" modelAttribute="commentBean" method="post">
                            <div class="form-group">
                                <label for="guest">
                                    Your Name:
                                </label>
                                <s1:input path="guest" cssClass="form-control"/><s1:errors path="guest"/>
                            </div>
                            <div class="form-group">
                                <label for="comment">
                                    Comment:
                                </label>
                                <s1:textarea path="comment" cssClass="form-control"/><s1:errors path="comment"/>
                            </div>
                            <input type="text" value="${watchList.id}" name="watchListId" hidden>
                            <input type="submit" value="Submit" class="btn btn-primary btn-block">
                        </s1:form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${watchList.comments}" var="comment">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header">
                                ${comment.guest}
                        </div>
                        <div class="card-body">
                            <p class="card-text">${comment.comment}</p>
                            <div class="card-footer text-muted">
                                    ${comment.date}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
