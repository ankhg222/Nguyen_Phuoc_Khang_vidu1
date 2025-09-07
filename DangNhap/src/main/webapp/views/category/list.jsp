<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            margin-bottom: 15px;
        }

        a.btn-add {
            display: inline-block;
            margin-bottom: 12px;
            padding: 8px 14px;
            background: #28a745;
            color: white;
            border-radius: 4px;
            text-decoration: none;
        }
        a.btn-add:hover {
            background: #218838;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            border: 1px solid #ddd; /* kẻ khung */
            padding: 10px;
            text-align: center;
        }

        th {
            background: #343a40;
            color: #fff;
        }

        tr:nth-child(even) {
            background: #f8f9fa; /* xen kẽ màu nền */
        }

        img {
            width: 70px;
            height: 70px;
            object-fit: cover;
        }

        a.btn-edit {
            color: #ffc107;
            text-decoration: none;
            margin-right: 8px;
        }
        a.btn-delete {
            color: #dc3545;
            text-decoration: none;
        }
        a.btn-edit:hover { text-decoration: underline; }
        a.btn-delete:hover { text-decoration: underline; }
    </style>
</head>
<body>

<h2>Danh sách Category</h2>
<a href="${pageContext.request.contextPath}/category/add" class="btn-add">+ Thêm Category</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Icon</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${cateList}">
        <tr>
            <td>${c.cateId}</td>
            <td>${c.cateName}</td>
            <td>
                <img src="${pageContext.request.contextPath}/uploads/${c.icon}" alt="icon">
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/category/edit?id=${c.cateId}" class="btn-edit">Sửa</a>
                <a href="${pageContext.request.contextPath}/category/delete?id=${c.cateId}"
                   class="btn-delete"
                   onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
