<%-- 
    Document   : single
    Created on : Mar 7, 2023, 4:23:46 PM
    Author     : LENOVO
--%>
<%@include file="/commons/tablib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <section class="single">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="home">Home</a></li>
                            <li class="active">${news.category.name}</li>
                        </ol>
                        <article class="article main-article">
                            <header>
                                <h1>${news.title}</h1>
                                <ul class="details">
                                    <li>Posted on ${news.createdDate}</li>
                                    <li><a>${news.category.name}</a></li>
                                    <li>By <a href="#">${news.createdBy}</a></li>
                                </ul>
                            </header>
                            <div class="main">
                                ${news.desc}
                            </div>
                            <footer>
                                <div class="col">
                                </div>
                                <div class="col">
                                    <a href="#" class="love"><i class="ion-ios-eye"></i> <div>${news.viewer}</div></a>
                                </div>
                            </footer>
                        </article>
                        <div class="line">
                            <div>Author</div>
                        </div>
                        <div class="author">
                            <figure>
                                <img src="<c:url value="/template/web/images/img01.jpg" />">
                            </figure>
                            <div class="details">
                                <h3 class="name">${news.createdBy}</h3>
                                <p>Thanks for reading</p>
                                <ul class="social trp sm">
                                    <li>
                                        <a href="http://facebook.com" class="facebook">
                                            <svg><rect/></svg>
                                            <i class="ion-social-facebook"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://www.youtube.com" class="youtube">
                                            <svg><rect/></svg>
                                            <i class="ion-social-youtube"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://www.gmail.com" class="googleplus">
                                            <svg><rect/></svg>
                                            <i class="ion-social-google"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://www.instagram.com" class="instagram">
                                            <svg><rect/></svg>
                                            <i class="ion-social-instagram-outline"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="line thin"></div>
                        <div class="comments">
                            <h2 class="title">Responses <a href="#">Write a Response</a></h2>
                            <div class="comment-list">
                                <c:forEach var="comment" items="${commentList}">
                                    <div class="item">
                                        <div class="user">                                
                                            <figure>
                                                <img src="<c:url value="/template/web/images/img01.jpg"/>">
                                            </figure>
                                            <div class="details">
                                                <h5 class="name">${comment.account.fullName}</h5>
                                                <div class="time">${comment.createdDate}</div>
                                                <div class="description">
                                                    ${comment.desc}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <form class="row" action="comment" method="post">
                                <div class="col-md-12">
                                    <h3 class="title">Leave Your Response</h3>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="message">Response <span class="required"></span></label>
                                    <textarea class="form-control" name="desc" placeholder="Write your response ..."></textarea>
                                </div>
                                <input type="hidden" name="action" value="create"/>
                                <input type="hidden" name="newsId" value="${news.id}"/>
                                <div class="form-group col-md-12">
                                    <input type="submit" class="btn btn-primary" value="Send Response" />
                                </div>
                            </form>
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
