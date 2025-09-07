<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Sửa sản phẩm</h2>
<form action="${pageContext.request.contextPath}/product/edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="productId" value="${product.productId}">

    <div class="mb-3">
        <label class="form-label">Tên sản phẩm</label>
        <input type="text" name="productName" class="form-control" value="${product.productName}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Giá</label>
        <input type="number" name="price" class="form-control" value="${product.price}" required>
    </div>
    <div class="mb-3">
        <label class="form-label">Ảnh hiện tại</label><br>
        <img src="${pageContext.request.contextPath}/uploads/${product.image}" width="80" height="80"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Chọn ảnh mới</label>
        <input type="file" name="imageFile" class="form-control" accept="image/*">
    </div>
    <div class="mb-3">
        <label class="form-label">Danh mục</label>
        <select name="categoryId" class="form-select">
            <c:forEach var="c" items="${categoryList}">
                <option value="${c.cateId}" <c:if test="${c.cateId == product.categoryId}">selected</c:if>>
                    ${c.cateName}
                </option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Cập nhật</button>
    <a href="${pageContext.request.contextPath}/product/list" class="btn btn-secondary">Quay lại</a>
</form>

</body>
</html>
