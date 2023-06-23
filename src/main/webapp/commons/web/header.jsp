<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/commons/tablib.jsp" %>

<jsp:useBean id="categories" class="com.toandone.magznews.model.CategoryList"/>

<header class="primary">
    <div class="firstbar">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-12">
                    <div class="brand">
                        <a href="home">
                            <img src="<c:url value='/template/web/images/logo.png'/>" alt="Magz Logo">
                        </a>
                    </div>						
                </div>
                <div class="col-md-6 col-sm-12">
                    <form class="search" autocomplete="off" action="home">
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" name="key" class="form-control" placeholder="Type something here" value="${key}">
                                <input type="hidden" name="action" value="search"/>
                                <div class="input-group-btn">
                                    <button class="btn btn-primary"><i class="ion-search"></i></button>
                                </div>
                            </div>
                        </div>
                    </form>								
                </div>
                <div class="col-md-3 col-sm-12 text-right">
                    <ul class="nav-icons">
                        <c:if test="${empty USERMODEL}">
                            <li><a href="login?action=register"><i class="ion-person-add"></i><div>Register</div></a></li>
                            <li><a href="login?action=login"><i class="ion-log-in"></i><div>Login</div></a></li>
                                    </c:if>
                                    <c:if test="${not empty USERMODEL}">
                            <li><a href="home?action=profile"><i class="ion-person"></i><div>Welcome, ${USERMODEL.fullName}</div></a></li>
                            <li><a href="logout?action=logout"><i class="ion-log-out"></i><div>Logout</div></a></li>
                                    </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!-- Start nav -->
    <nav class="menu">
        <div class="container">
            <div class="brand">
                <a href="home">
                    <img src="<c:url value='/template/web/images/logo.png'/>" alt="Magz Logo">
                </a>
            </div>
            <div class="mobile-toggle">
                <a href="#" data-toggle="menu" data-target="#menu-list"><i class="ion-navicon-round"></i></a>
            </div>
            <div class="mobile-toggle">
                <a href="#" data-toggle="sidebar" data-target="#sidebar"><i class="ion-ios-arrow-left"></i></a>
            </div>
            <div id="menu-list">
                <ul class="nav-list">
                    <li class="for-tablet nav-title"><a>Menu</a></li>
                    <li class="for-tablet"><a href="login?action=login">Login</a></li>
                    <li class="for-tablet"><a href="login?action=register">Register</a></li>
                        <c:if test="${USERMODEL != null && !USERMODEL.role.code.equals('user')}">
                        <li><a href="admin-news">Admin</a></li>
                        </c:if>
                        <c:forEach var="category" items="${categories.list}">
                        <li><a href="category?id=${category.id}">${category.name}</a></li>
                        </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
    <!-- End nav -->
</header>
