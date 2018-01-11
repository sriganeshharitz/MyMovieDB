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
    <div class="container">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading text-center">Hurrayy!!</h4>
            <p class="text-center">Found ${watchList.movies.size()} movies in ${watchList.name}</p>
            <hr>
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <a href="showShareView?listName=${listName}" class="btn btn-success btn-block">Share this list with friends!</a>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <c:forEach items="${watchList.movies}" var="movie">
                <div class="col-md-4">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">${movie.title}</h4>
                            <p>${movie.release_date}</p>
                            <p>Review: ${movie.user_review}</p>
                            <%--<p class="card-text">${.overview}</p>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row mb-3">
            <div class="col-md-8 offset-md-2">
                <h4 class="display-4">Comments:</h4>
            </div>
            <c:forEach items="${watchList.comments}" var="comment">
                <div class="col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-header">
                                ${comment.guest}
                        </div>
                        <div class="card-body">
                            <p class="card-text">${comment.comment}</p>
                        </div>
                        <div class="card-footer text-muted">
                                ${comment.date}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row mb-3">
            <div class="col-md-8 offset-md-2">
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
    </div>
</body>
</html>
