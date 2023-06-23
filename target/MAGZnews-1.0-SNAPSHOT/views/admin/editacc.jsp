<%-- 
    Document   : editacc
    Created on : Mar 10, 2023, 11:59:04 AM
    Author     : LENOVO
--%>
<%@include file="/commons/tablib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
    </head>
    <body>
        <div class="container-xxl flex-grow-1 container-p-y">
            <div class="row">
                <div class="col-xl">
                    <div class="card mb-4">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">
                                <c:if test="${empty model.id}">Create account</c:if><c:if test="${not empty model.id}">Update account</c:if>
                                </h5>
                            </div>
                            <div class="card-body">
                                <form action="admin-account" method="post">
                                    <div class="mb-3">
                                        <label for="roleSelect" class="form-label">Role</label>
                                        <select class="form-select" id="roleSelect" aria-label="Role selection" name="roleId">
                                            <option selected>Open this select menu</option>
                                        <c:forEach var="role" items="${roleList}">
                                            <option value="${role.id}" <c:if test="${role.id == model.role.id}">selected</c:if>>${role.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-fullname">Fullname</label>
                                    <input type="text" class="form-control" id="basic-default-fullname" name="fullName" placeholder="Enter fullname" value="${model.fullName}"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-user">Username</label>
                                    <input type="text" class="form-control" id="basic-default-user" name="user" placeholder="Enter username"  value="${model.user}"/>
                                </div>

                                <div class="mb-3 form-password-toggle">
                                    <label class="form-label" for="basic-default-pass">Password</label>
                                    <div class="input-group input-group-merge">
                                        <input type="password" class="form-control" id="password" name="pass" placeholder="Enter password" value="${model.pass}"/>
                                        <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                                    </div>
                                </div>

                                <c:if test="${empty model.id}">
                                    <input type="hidden" name="action" value="create"/>
                                </c:if>


                                <c:if test="${not empty model.id}">
                                    <input type="hidden" name="action" value="update"/>
                                    <input type="hidden" name="id" value="${model.id}"/>
                                </c:if>

                                <button type="submit" class="btn btn-primary">Save account</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
