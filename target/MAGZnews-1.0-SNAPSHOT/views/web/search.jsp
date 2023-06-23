<%-- 
    Document   : search.jsp
    Created on : Mar 10, 2023, 10:10:59 PM
    Author     : LENOVO
--%>

<%@include file="/commons/tablib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <section class="search">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="search-result">
                            Search results for keyword "${key}"
                        </div>
                        <div class="row">
                            <c:forEach var="news" items="${searchList}">
                                <article class="col-md-12 article-list">
                                    <div class="inner">
                                        <figure>
                                            <a href="home?action=view&id=${news.id}">
                                                <img src="<c:url value="/template/web/images/news/${news.thumnail}"/>">
                                            </a>
                                        </figure>
                                        <div class="details">
                                            <div class="detail">
                                                <div class="category">
                                                    <a href="category?id=${news.category.id}">${news.category.name}</a>
                                                </div>
                                                <time>${news.createdDate}</time>
                                            </div>
                                            <h1><a href="home?action=view&id=${news.id}">${news.title}</a></h1>
                                            <p>
                                                ${news.shortDesc}
                                            </p>
                                            <footer>
                                                <a href="#" class="love"><i class="ion-ios-eye"></i> <div>${news.viewer}</div></a>
                                                <a class="btn btn-primary more" href="home?action=view&id=${news.id}">
                                                    <div>More</div>
                                                    <div><i class="ion-ios-arrow-thin-right"></i></div>
                                                </a>
                                            </footer>
                                        </div>
                                    </div>
                                </article>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
