<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html lang="vi"><head>
<meta charset="UTF-8"><title>Quản lý danh mục</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head><body class="bg-light">
<div class="container py-4">
  <h3 class="mb-3">Quản lý danh mục</h3>
  <div class="row g-4">
    <div class="col-md-7">
      <div class="card"><div class="card-header">Danh sách danh mục</div>
        <div class="card-body p-0">
          <table class="table table-striped mb-0">
            <thead><tr><th>ID</th><th>Tên danh mục</th><th>Icon</th><th>Hành động</th></tr></thead>
            <tbody>
            <c:forEach var="c" items="${items}">
              <tr>
                <td>${c.categoryId}</td>
                <td>${c.categoryname}</td>
                <td><img src="${pageContext.request.contextPath}/uploads/${c.images}" style="height:28px"></td>
                <td>
                  <a class="me-2" href="${pageContext.request.contextPath}/admin/category/edit?id=${c.categoryId}">Cập nhật</a>
                  <a class="text-danger" href="${pageContext.request.contextPath}/admin/category/delete?id=${c.categoryId}"
                     onclick="return confirm('Xóa danh mục này?')">Xóa</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <div class="col-md-5">
      <div class="card">
        <div class="card-header">${empty item ? 'Thêm danh mục' : 'Cập nhật danh mục'}</div>
        <div class="card-body">
          <form method="post" action="${pageContext.request.contextPath}/admin/category/${empty item ? 'create' : 'update'}">
            <c:if test="${not empty item}">
              <input type="hidden" name="id" value="${item.categoryId}">
            </c:if>
            <div class="mb-3">
              <label class="form-label">Tên danh mục</label>
              <input class="form-control" name="name" value="${item.categoryname}">
            </div>
            <div class="mb-3">
              <label class="form-label">Icon</label>
              <input class="form-control" name="images" value="${item.images}">
            </div>
            <div class="mb-3">
              <label class="form-label">Trạng thái</label>
              <input class="form-control" name="status" type="number" value="${empty item ? 1 : item.status}">
            </div>
            <button class="btn btn-primary" type="submit">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body></html>
