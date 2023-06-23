<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/commons/tablib.jsp" %>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12 col-xs-12 mt-2">
                <div class="block">
                    <h1 class="block-title">Company Info</h1>
                    <div class="block-body">
                        <figure class="foot-logo">
                            <img src="<c:url value='/template/web/images/logo-light.png'/>" class="img-responsive" alt="Logo">
                        </figure>
                        <p class="brand-description">
                            Magz is a best news in my heart.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-12 col-xs-12 mt-2">
                <div class="block">
                    <h1 class="block-title">Newsletter</h1>
                    <div class="block-body">
                        <p>By subscribing you will receive new articles in your email.</p>
                        <form class="newsletter">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="ion-ios-email-outline"></i>
                                </div>
                                <input type="email" class="form-control email" placeholder="Your mail">
                            </div>
                            <button class="btn btn-primary btn-block white">Subscribe</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-12 col-xs-12 mt-2">
                <div class="block">
                    <h1 class="block-title">Follow Us</h1>
                    <div class="block-body">
                        <p>Follow us and stay in touch to get the latest news</p>
                        <ul class="social trp">
                            <li>
                                <a href="https://www.facebook.com" class="facebook">
                                    <svg><rect width="0" height="0"></rect></svg>
                                    <i class="ion-social-facebook"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.youtube.com" class="youtube">
                                    <svg><rect width="0" height="0"></rect></svg>
                                    <i class="ion-social-youtube-outline"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.gmail.com" class="googleplus">
                                    <svg><rect width="0" height="0"></rect></svg>
                                    <i class="ion-social-google"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.instagram.com" class="instagram">
                                    <svg><rect width="0" height="0"></rect></svg>
                                    <i class="ion-social-instagram-outline"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="copyright">
                    COPYRIGHT © TOANDONE 2023. ALL RIGHT RESERVED.
                    <div>
                        Made with <i class="ion-heart"></i> by <a href="https://www.facebook.com/thetoan209">TOANDONE</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
