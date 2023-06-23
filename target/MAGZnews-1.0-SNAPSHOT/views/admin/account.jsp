<%-- 
    Document   : account
    Created on : Mar 9, 2023, 9:26:02 PM
    Author     : LENOVO
--%>

<%@include file="/commons/tablib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>
    <body>
        <div class="container-xxl flex-grow-1 container-p-y">
            <div class="card">
                <h5 class="card-header">List of account</h5>
                <div class="m-4 mt-2 mb-3">
                    <label for="roleSelect" class="form-label">Select role</label>
                    <select id="roleSelect" class="form-select form-select-lg" name="roleId" onchange="change(this.value);">

                        <option value="0" <c:if test="${roleSelected == '0'}">selected</c:if>>All</option>
                        <c:forEach var="role" items="${roleList}">
                            <option value="${role.id}" <c:if test="${role.id == roleSelected}">selected</c:if>>${role.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="table-responsive text-nowrap">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Fullname</th>
                                <th>Role</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody class="table-border-bottom-0">
                            <c:forEach var="acc" items="${accList}">
                                <tr>
                                    <td style="white-space:pre-wrap; word-wrap:break-word"><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${acc.user}</strong></td>
                                    <td style="white-space:pre-wrap; word-wrap:break-word">${acc.fullName}</td>
                                    <td><span class="badge bg-label-${acc.role.id == 1 ? 'warning' : (acc.role.id == 2 ? 'success' : 'info')} me-1">${acc.role.name}</span></td>
                                    <td>
                                        <div class="dropdown">
                                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                                <i class="bx bx-dots-vertical-rounded"></i>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="admin-account?action=update&id=${acc.id}"
                                                   ><i class="bx bx-edit-alt me-1"></i> Edit</a
                                                >
                                                <a class="dropdown-item" onclick="doDelete('${acc.id}', '${acc.fullName}');"
                                                   ><i class="bx bx-trash me-1"></i> Delete</a
                                                >
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script>
            function change(value) {
                window.location = 'admin-account?action=list&roleId=' + value;
            }

            function doDelete(id, name) {
                if (confirm('Do you want to remove account: ' + name + '?')) {
                    post("admin-account", {'action': 'delete', 'id': id});
                }
            }

            function post(path, parameters) {
                var form = $('<form></form>');

                form.attr("method", "post");
                form.attr("action", path);

                $.each(parameters, function (key, value) {
                    var field = $('<input></input>');

                    field.attr("type", "hidden");
                    field.attr("name", key);
                    field.attr("value", value);

                    form.append(field);
                });

                // The form needs to be a part of the document in
                // order for us to be able to submit it.
                $(document.body).append(form);
                form.submit();
            }
        </script>
    </body>
</html>
