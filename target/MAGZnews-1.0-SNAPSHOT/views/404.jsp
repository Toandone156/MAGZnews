<%-- 
    Document   : 404
    Created on : Mar 6, 2023, 8:19:18 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/commons/web/css.jsp"/>

    </head>
    <body class="skin-orange">

        <jsp:include page="/commons/web/header.jsp"/>


        <section class="not-found">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="code">
                            404
                        </div>
                        <h1>Page could not be found</h1>
                        <p class="lead">The page you are looking for is not available please check the url you are going to.</p>
                        <div class="search-form">									
                            <div class="link">
                                or <a href="home">back to home</a>.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <jsp:include page="/commons/web/footer.jsp"/>

        <jsp:include page="/commons/web/js.jsp"/>
        <script>
            toastr.options = {
                "closeButton": true,
                "debug": false,
                "newestOnTop": true,
                "progressBar": false,
                "positionClass": "toast-top-right",
                "preventDuplicates": true,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            }

            <c:if test="${not empty message}">
                        toastr["${type}"]("${message}", "${type == 'error' ? 'Error' : 'Success'}")
                        </c:if>
                </script>
                </body>
                </html>
