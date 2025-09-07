<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Danh sách người dùng</h2>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Fullname</th>
        <th>Role</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${userList}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.email}</td>
            <td>${u.fullname}</td>
            <td>${u.roleid}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/edit?id=${u.id}" class="btn btn-warning btn-sm">Sửa</a>
                <a href="${pageContext.request.contextPath}/user/delete?id=${u.id}" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Xóa user này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
