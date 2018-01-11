<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/26/2017
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s1"%>
<html>
<head>
    <title>Title</title>
    <%@include file="BootStrapCDN.jsp"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">
        .myHidden {
            display: none;
        }
    </style>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script type="text/javascript"
            src="https://viralpatel.net/blogs/demo/jquery/jquery.shorten.1.0.js"></script>
</head>
<body>
    <%@include file="Header.jsp"%>
    <div class="container">
        <h4>List with name ${listName} has been created! Add movies to the list</h4>
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="searchMovieForList">
                    <div class="form-group">
                        <label for="searchName">
                            Search Movies
                        </label>
                        <input type="text" name="searchName" class="form-control" id="searchName">
                        <input type="text" name="listName" value="${listName}" hidden>
                        <p class="text-danger">${msg}</p>
                        <input type="submit" value="Search" class="btn btn-success">
                    </div>
                </form>
            </div>
        </div>
        <%--<c:if test="${movieResults}">--%>
            <%--<h6 class="text-success">Found ${movieResults.results.size()} matches!</h6>--%>
        <%--</c:if>--%>
        <div class="row">
            <c:forEach items="${movieResults.results}" var="result">
                <div class="col-md-4 mb-3">
                    <div class="card" style="width: 20rem;">
                        <img class="card-img-top" src="https://image.tmdb.org/t/p/w500${result.poster_path}" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">${result.title}</h4>
                            <p>${result.release_date}</p>
                            <p class="card-text overview">${result.overview}</p>
                            <form action="addMovieToList" method="post">
                                <div class="myHidden">
                                    <input type="text" name="title" value="${result.title}" ><br>
                                    <input type="text" name="overview"  value="${result.overview}"><br>
                                    <input type="text" name="id"  value="${result.id}"><br>
                                    <input type="text" name="poster_path" value="${result.poster_path}"><br>
                                    <input type="text" name="release_date"  value="${result.release_date}"><br>
                                    <input type="text" name="watchList.name"  value="${listName}">
                                </div>
                                <div class="form-group">
                                    <label for="user_review">Your review:</label>
                                    <textarea rows="4" cols="50" name="user_review" id="user_review" class="form-control">
                                    </textarea>
                                </div>

                                <input type="submit" value="Add" class="btn btn-primary">
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <%--<div class="row">--%>
            <%--<div class="card-group">--%>
                    <%--<c:forEach items="${movieResults.results}" var="result">--%>
                        <%--<div class="col-md-4 h-25">--%>
                            <%--<div class="card">--%>
                                <%--<img class="card-img-top" src="https://image.tmdb.org/t/p/w500${result.poster_path}" alt="Card image cap">--%>
                                <%--<div class="card-body">--%>
                                    <%--<h5 class="card-title">${result.title}</h5>--%>
                                    <%--<p class="card-text">${result.overview}</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                    <%--</c:forEach>--%>

            <%--</div>--%>
        <%--</div>--%>

    </div>
    <script type="text/javascript">
        $("#searchName").keyup(
            function () {
                $("#searchName").autocomplete(
                    {
                        source:'/search?query='+$("#searchName").val()
                    }
                );
            }
        );
    </script>
    <script type="text/javascript">
        $(document).ready(function() {

            $(".overview").shorten();

        });
    </script>
</body>
</html>
