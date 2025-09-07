<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-3">Danh sách sản phẩm</h2>
<a href="${pageContext.request.contextPath}/product/add" class="btn btn-success mb-3">+ Thêm sản phẩm</a>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Hình ảnh</th>
        <th>Giá</th>
        <th>Danh mục</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${productList}">
        <tr>
            <td>${p.productId}</td>
            <td>${p.productName}</td>
            <td>
                <img src="${pageContext.request.contextPath}/uploads/${p.image}" width="60" height="60"/>
            </td>
            <td>${p.price}</td>
            <td>${p.categoryName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/product/edit?id=${p.productId}" class="btn btn-warning btn-sm">Sửa</a>
                <a href="${pageContext.request.contextPath}/product/delete?id=${p.productId}" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
