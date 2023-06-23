<%@include file="/commons/tablib.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
    lang="en"
    class="light-style layout-menu-fixed"
    dir="ltr"
    data-theme="theme-default"
    data-assets-path="<c:url value="/template/admin/"/>"
    data-template="vertical-menu-template-free"
    >
    <head>
        <title><dec:title default="Home" /></title>

        <!--Css-->
        <!-- Favicon -->
        <link rel="icon" type="image/x-icon" href="<c:url value='/template/admin/img/favicon/favicon.ico'/>" />

        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

        <!-- Icons. Uncomment required icon fonts -->
        <link rel="stylesheet" href="<c:url value='/template/admin/vendor/fonts/boxicons.css'/>" />

        <!-- Core CSS -->
        <link rel="stylesheet" href="<c:url value='/template/admin/vendor/css/core.css'/>" class="template-customizer-core-css'/>" />
        <link rel="stylesheet" href="<c:url value='/template/admin/vendor/css/theme-default.css'/>" class="template-customizer-theme-css'/>" />
        <link rel="stylesheet" href="<c:url value='/template/admin/css/demo.css'/>" />

        <!-- Vendors CSS -->
        <link rel="stylesheet" href="<c:url value='/template/admin/vendor/libs/perfect-scrollbar/perfect-scrollbar.css'/>" />

        <!-- Helpers -->
        <script src="<c:url value='/template/admin/vendor/js/helpers.js'/>"></script>

        <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
        <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
        <script src="<c:url value='/template/admin/js/config.js'/>"></script>

        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.4/toastr.min.css" integrity="sha512-6S2HWzVFxruDlZxI3sXOZZ4/eJ8AcxkQH1+JjSe/ONCEqR9L4Ysq5JdT5ipqtzU7WHalNwzwBv+iE51gNHJNqQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <script src="<c:url value='/template/ckeditor/ckeditor.js' />"></script>
    </head>
    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <jsp:include page="/commons/admin/menu.jsp"/>
                <div class="layout-page">
                    <jsp:include page="/commons/admin/navbar.jsp"/>
                    <div class="content-wrapper">
                        <dec:body/>
                        <jsp:include page="/commons/admin/footer.jsp"/>
                    </div>
                </div>

            </div>
        </div>



        <!-- Core JS -->
        <!-- build:js assets/vendor/js/core.js -->
        <script src="<c:url value='/template/admin/vendor/libs/jquery/jquery.js'/>"></script>
        <script src="<c:url value='/template/admin/vendor/libs/popper/popper.js'/>"></script>
        <script src="<c:url value='/template/admin/vendor/js/bootstrap.js'/>"></script>
        <script src="<c:url value='/template/admin/vendor/libs/perfect-scrollbar/perfect-scrollbar.js'/>"></script>

        <script src="<c:url value='/template/admin/vendor/js/menu.js'/>"></script>
                <script src="<c:url value='/template/admin/vendor/js/helpers.js'/>"></script>

        <!-- endbuild -->

        <!-- Vendors JS -->
        <script src="<c:url value='/template/admin/vendor/libs/apex-charts/apexcharts.js'/>"></script>

        <!-- Main JS -->
        <script src="<c:url value='/template/admin/js/main.js'/>"></script>

        <!-- Page JS -->
        <script src="<c:url value='/template/admin/js/dashboards-analytics.js'/>"></script>

        <!-- Place this tag in your head or just before your close body tag. -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/2.1.4/toastr.min.js" integrity="sha512-lbwH47l/tPXJYG9AcFNoJaTMhGvYWhVM9YI43CT+uteTRRaiLCui8snIgyAN8XWgNjNhCqlAUdzZptso6OCoFQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

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
