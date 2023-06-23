<%@include file="/commons/tablib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
    </head>
    <body>
        <section class="category">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12 text-left">
                        <div class="row">
                            <div class="col-md-12">        
                                <ol class="breadcrumb">
                                    <li><a href="home">Home</a></li>
                                    <li class="active">${empty category ? 'All' : category.name}</li>
                                </ol>
                                    <h1 class="page-title">Category: ${empty category ? 'All' : category.name}</h1>
                                    <p class="page-subtitle">Showing all posts <c:if test="${not empty category}">with category <i>${category.name}</i></c:if></p>
                            </div>
                        </div>
                        <div class="line"></div>
                        <div class="row">
                            <c:forEach var="news" items="${newsList}">
                                <article class="col-md-12 article-list">
                                    <div class="inner">
                                        <figure>
                                            <a href="single.html">
                                                <img src="<c:url value='/template/web/images/news/${news.thumnail}'/>">
                                            </a>
                                        </figure>
                                        <div class="details">
                                            <div class="detail">
                                                <div class="category">
                                                    <a href="category?id=${news.category.id}">${news.category.name}</a>
                                                </div>
                                                <div class="time">${news.createdDate}</div>
                                            </div>
                                            <h1><a href="home?action=view&id=${news.id}">${news.title}</a></h1>
                                            <p>${news.shortDesc}</p>
                                            <footer>
                                                <a href="#" class="love"><i class="ion-ios-eye"></i> <div>${news.viewer}</div></a>
                                                <a class="btn btn-primary more" href="category?id=${news.category.id}">
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

                    <div class="col-xs-6 col-md-4 sidebar" id="sidebar">
                        <div class="sidebar-title for-tablet">Sidebar</div>
                        <aside>
                            <h1 class="aside-title">Popular <a href="category" class="all">See All <i class="ion-ios-arrow-right"></i></a></h1>
                            <div class="aside-body">
                                <c:forEach var="news" items="${popularList}">
                                    <article class="article-mini">
                                        <div class="inner">
                                            <figure>
                                                <a href="home?action=view&id=${news.id}">
                                                    <img src="<c:url value='/template/web/images/news/${news.thumnail}'/>" alt="${news.title}">
                                                </a>
                                            </figure>
                                            <div class="padding">
                                                <h1><a href="home?action=view&id=${news.id}">${news.title}</a></h1>
                                            </div>
                                        </div>
                                    </article>
                                </c:forEach>
                            </div>
                        </aside>
                        <aside>
                            <div class="aside-body">
                                <form class="newsletter">
                                    <div class="icon">
                                        <i class="ion-ios-email-outline"></i>
                                        <h1>Newsletter</h1>
                                    </div>
                                    <div class="input-group">
                                        <input type="email" class="form-control email" placeholder="Your mail">
                                        <div class="input-group-btn">
                                            <button class="btn btn-primary"><i class="ion-paper-airplane"></i></button>
                                        </div>
                                    </div>
                                    <p>By subscribing you will receive new articles in your email.</p>
                                </form>
                            </div>
                        </aside>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
