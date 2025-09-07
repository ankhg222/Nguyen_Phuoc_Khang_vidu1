<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
        }
        .sidebar {
            width: 220px;
            height: 100vh;
            position: fixed;
            top: 0; left: 0;
            background: #007bff;
            color: white;
            padding-top: 20px;
        }
        .sidebar h4 {
            text-align: center;
            margin-bottom: 20px;
        }
        .sidebar a {
            display: block;
            padding: 10px 15px;
            color: white;
            text-decoration: none;
        }
        .sidebar a:hover {
            background: #0056b3;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
        }
        .header {
            background: #f8f9fa;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h4>Ban là Admin</h4>
    <a href="#">Dashboard</a>
    <a href="${pageContext.request.contextPath}/category/list">Quản lý Danh mục</a>
    <a href="${pageContext.request.contextPath}/category/add">+ Thêm danh mục mới</a>
    <a href="#">Quản lý sản phẩm</a>
    <a href="#">Quản lý tài khoản</a>
</div>

<!-- Content -->
<div class="content">
    <div class="header">
        <span>Xin chào: Nguyễn Hữu Trung</span>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm">Đăng xuất</a>
    </div>

    <!-- Đây là phần sẽ include -->
    <jsp:include page="../views/category/list.jsp"/>
</div>

</body>
</html>
