<%@include file="/commons/tablib.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <section class="login first grey">
            <div class="container">
                <div class="box-wrapper">				
                    <div class="box box-border">
                        <div class="box-body">
                            <h4>Login</h4>
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" name="user" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="fw">Password</label>
                                    <input type="password" name="pass" class="form-control">
                                </div>
                                <input type="hidden" name="action" value="login"/>
                                <div class="form-group text-right">
                                    <button class="btn btn-primary btn-block">Login</button>
                                </div>
                                <div class="form-group text-center">
                                    <span class="text-muted">Don't have an account?</span> <a href="login?action=register">Create one</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
