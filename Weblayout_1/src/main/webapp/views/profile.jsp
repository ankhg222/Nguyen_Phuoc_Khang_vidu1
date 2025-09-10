<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<div class="container">
    <h2 class="mb-4">Cập nhật thông tin cá nhân</h2>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty err}">
        <div class="alert alert-danger">${err}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="fullName" class="form-label">Họ tên</label>
            <input type="text" id="fullName" name="fullName" class="form-control"
                   value="${user.fullname}" required>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại</label>
            <input type="text" id="phone" name="phone" class="form-control"
                   value="${user.phone}">
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Ảnh đại diện</label><br>
            <c:if test="${not empty user.avatar}">
                <img src="${pageContext.request.contextPath}/${user.avatar}" width="120" class="mb-2"/>
            </c:if>
            <input type="file" id="image" name="image" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
</body>
</html>
