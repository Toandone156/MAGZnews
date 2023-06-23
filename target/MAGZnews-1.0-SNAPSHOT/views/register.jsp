<%-- 
    Document   : register
    Created on : Mar 9, 2023, 7:17:32 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <section class="login first grey">
            <div class="container">
                <div class="box-wrapper">				
                    <div class="box box-border">
                        <div class="box-body">
                            <h4>Register</h4>
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" name="fullName" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" name="user" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label class="fw">Password</label>
                                    <input type="password" name="pass" class="form-control">
                                </div>
                                
                                <input type="hidden" name="action" value="register"/>
                                
                                <div class="form-group text-right">
                                    <input type="submit" class="btn btn-primary btn-block" value="Register" />
                                </div>
                                <div class="form-group text-center">
                                    <span class="text-muted">Already have an account?</span> <a href="login?action=login">Login</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
