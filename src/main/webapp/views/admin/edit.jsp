<%@include file="/commons/tablib.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${empty model.id}">
            <title>Create news</title>
        </c:if>
        <c:if test="${not empty model.id}">
            <title>Update news</title>
        </c:if>
    </head>
    <body>
        <div class="container-xxl flex-grow-1 container-p-y">
            <div class="row">
                <div class="col-xl">
                    <div class="card mb-4">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">
                                <c:if test="${empty model.id}">Create news</c:if><c:if test="${not empty model.id}">Update news</c:if>
                                </h5>
                            </div>
                            <div class="card-body">
                                <form action="admin-news" method="post">
                                    <div class="mb-3">
                                        <label for="categorySelect" class="form-label">Category</label>
                                        <select class="form-select" id="categorySelect" aria-label="Category selection" name="categoryCode">
                                            <option selected>Open this select menu</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option 
                                                value="${category.code}" 
                                                <c:if test="${category.code == model.category.code}">selected</c:if>>
                                                ${category.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-title">Title</label>
                                        <input type="text" class="form-control" id="basic-default-title" name="title" placeholder="Enter news title" value="${model.title}"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-thumbnail">Thumbnail</label>
                                    <input type="text" class="form-control" id="basic-default-thumbnail" name="thumnail" placeholder="Enter news thumbnail"  value="${model.thumnail}"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-shortdesc">Short Description</label>
                                    <input type="text" class="form-control" id="basic-default-shortdesc" name="shortDesc" placeholder="Enter news short description" value="${model.shortDesc}"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="basic-default-desc">Description</label>
                                    <textarea
                                        id="basic-default-desc"
                                        class="form-control"
                                        placeholder="Enter news description"
                                        name="desc" 
                                        > ${model.desc}</textarea>
                                </div>
                                <c:if test="${empty model.id}"><input type="hidden" name="action" value="create"></c:if>
                                <c:if test="${not empty model.id}">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="id" value="${model.id}">
                                </c:if>
                                <button type="submit" class="btn btn-primary">Save news</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var editor = '';
            $(document).ready(function () {
                editor = CKEDITOR.replace('basic-default-desc');
            });
        </script>
    </body>
</html>
