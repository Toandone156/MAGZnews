<%@include file="/commons/tablib.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><dec:title default="Home"/></title>
        <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/template/web/images/favicon-16x16.png"/>">
        <jsp:include page="/commons/web/css.jsp"/>

    </head>
    <body class="skin-orange">

        <jsp:include page="/commons/web/header.jsp"/>


        <dec:body/>


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
