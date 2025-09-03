<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-3">Danh sách Category</h2>
<a href="${pageContext.request.contextPath}/category/add" class="btn btn-success mb-3">+ Thêm Category</a>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Icon</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${cateList}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.icon}</td>
            <td>
                <a href="${pageContext.request.contextPath}/category/edit?id=${c.id}" class="btn btn-warning btn-sm">Sửa</a>
                <a href="${pageContext.request.contextPath}/category/delete?id=${c.id}" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
