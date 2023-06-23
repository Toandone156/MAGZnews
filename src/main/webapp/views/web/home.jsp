<%@include file="/commons/tablib.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <section class="home">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <div class="owl-carousel owl-theme slide" id="featured">

                            <c:forEach var="news" items="${lastestList}">
                                <div class="item">
                                    <article class="featured">
                                        <div class="overlay"></div>
                                        <figure>
                                            <img src="<c:url value='/template/web/images/news/${news.thumnail}'/>" alt="Sample Article">
                                        </figure>
                                        <div class="details">
                                            <div class="category"><a href="category.html">${news.category.name}</a></div>
                                            <h1><a href="home?action=view&id=${news.id}">${news.title}</a></h1>
                                            <div class="time">${news.createdDate}</div>
                                        </div>
                                    </article>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="line">
                            <div>Latest News</div>
                        </div>
                        <div class="row" style="display: flex;flex-wrap: wrap;">
                            <c:forEach var="news" items="${lastestList}">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <article class="article col-md-12">
                                        <div class="inner">
                                            <figure>
                                                <a href="home?action=view&id=${news.id}">
                                                    <img src="<c:url value='/template/web/images/news/${news.thumnail}'/>" alt="Sample Article">
                                                </a>
                                            </figure>
                                            <div class="padding">
                                                <div class="detail">
                                                    <div class="time">${news.createdDate}</div>
                                                    <div class="category"><a href="category.html">${news.category.name}</a></div>
                                                </div>
                                                <h2><a href="home?action=view&id=${news.id}">${news.title}</a></h2>
                                                <p>${news.shortDesc}</p>
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
                                </div>
                            </c:forEach>
                        </div>
                        <div class="line top">
                            <div>Recently news</div>
                        </div>
                        <div class="row">
                            <c:forEach var="news" items="${historyList}">
                                <article class="col-md-12 article-list">
                                    <div class="inner">
                                        <figure>
                                            <a href="home?action=view&id=${news.id}">
                                                <img src="<c:url value='/template/web/images/news/${news.thumnail}'/>" alt="Sample Article">
                                            </a>
                                        </figure>
                                        <div class="details">
                                            <div class="detail">
                                                <div class="category">
                                                    <a href="#">${news.category.name}</a>
                                                </div>
                                                <div class="time">${news.createdDate}</div>
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
