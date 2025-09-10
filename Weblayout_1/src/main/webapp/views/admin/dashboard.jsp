<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-4">
    <h2>Trang quản trị</h2>
    <p>Xin chào, Admin!</p>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Đăng xuất</a>
</div>
</body>
</html>
