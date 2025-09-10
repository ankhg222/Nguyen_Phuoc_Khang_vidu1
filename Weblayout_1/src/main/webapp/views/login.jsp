<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="d-flex align-items-center justify-content-center vh-100">
<div class="card p-4 shadow" style="width: 350px;">
    <h4 class="mb-3 text-center">Đăng nhập</h4>

    <c:if test="${not empty err}">
        <div class="alert alert-danger">${err}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="mb-3">
            <label class="form-label">Tên đăng nhập</label>
            <input type="text" name="username" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" name="password" class="form-control" required/>
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
    </form>
</div>
</body>
</html>
