<%-- 
    Document   : profile
    Created on : Mar 12, 2023, 2:56:21 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <section class="login first grey">
            <div class="container">
                <div class="box-wrapper">				
                    <div class="box box-border">
                        <div class="box-body">
                            <h4>Profile</h4>
                            <form action="home" method="post">
                                <div class="form-group">
                                    <label>FullName</label>
                                    <input type="text" name="fullName" class="form-control" value="${USERMODEL.fullName}">
                                </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" name="user" class="form-control" value="${USERMODEL.user}">
                                </div>
                                <div class="form-group">
                                    <label class="fw">Password</label>
                                    <input type="password" name="pass" class="form-control"  value="${USERMODEL.pass}">
                                </div>
                                <input type="hidden" name="action" value="profile"/>
                                <input type="hidden" name="id" value="${USERMODEL.id}"/>
                                <input type="hidden" name="roleId" value="${USERMODEL.role.id}"/>
                                <div class="form-group text-right">
                                    <button class="btn btn-primary btn-block">Update</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
