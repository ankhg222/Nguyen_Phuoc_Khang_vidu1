<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-3">Thêm Category</h2>
<form action="${pageContext.request.contextPath}/category/add" method="post" class="w-50">
    <div class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" name="name" class="form-control" required>
    </div>

    <div class="mb-3">
        <label class="form-label">Icon</label>
        <input type="text" name="icon" class="form-control">
    </div>

    <button type="submit" class="btn btn-primary">Lưu</button>
    <a href="${pageContext.request.contextPath}/category/list" class="btn btn-secondary">Hủy</a>
</form>

</body>
</html>
