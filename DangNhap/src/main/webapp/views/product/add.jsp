<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Thêm sản phẩm</h2>
<form action="${pageContext.request.contextPath}/product/add" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label class="form-label">Tên sản phẩm</label>
        <input type="text" name="productName" class="form-control" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Giá</label>
        <input type="number" name="price" class="form-control" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Hình ảnh</label>
        <input type="file" name="imageFile" class="form-control" accept="image/*">
    </div>
    <div class="mb-3">
        <label class="form-label">Danh mục</label>
        <select name="categoryId" class="form-select">
            <c:forEach var="c" items="${categoryList}">
                <option value="${c.cateId}">${c.cateName}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Lưu</button>
    <a href="${pageContext.request.contextPath}/admin/product/list" class="btn btn-secondary">Quay lại</a>
</form>

</body>
</html>
