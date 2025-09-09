<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Chỉnh sửa danh mục</title>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    body {font-family: Arial, sans-serif; background:#f5f5f5; margin:0; padding:20px;}
    .form-container {max-width:600px; margin:auto; background:#fff; padding:20px;
                     border:1px solid #ddd; border-radius:6px;}
    h2 {margin-bottom:20px;}
    .form-group {margin-bottom:15px;}
    label {display:block; margin-bottom:6px; font-weight:bold;}
    input[type="text"], input[type="file"] {
        width:100%; padding:8px; border:1px solid #ccc; border-radius:4px;
    }
    img {margin:10px 0; border:1px solid #ccc; border-radius:4px;}
    button, .btn-reset {
        padding:8px 16px; border:none; border-radius:4px; cursor:pointer;
    }
    button {background:#007bff; color:#fff;}
    button:hover {background:#0056b3;}
    .btn-reset {background:#6c757d; color:#fff; margin-left:10px;}
    .btn-reset:hover {background:#5a6268;}
  </style>
</head>
<body>
  <div class="form-container">
    <h2>Chỉnh sửa danh mục</h2>

    <form action="${pageContext.request.contextPath}/admin/category/edit"
          method="post" enctype="multipart/form-data">

      <!-- Hidden ID -->
      <input type="hidden" name="id" value="${cate.cateId}"/>

      <div class="form-group">
        <label for="name">Tên danh sách:</label>
        <input type="text" id="name" name="name" value="${cate.cateName}" required/>
      </div>

      <div class="form-group">
        <label>Ảnh hiện tại:</label>
        <c:if test="${not empty cate.icon}">
          <img src="${pageContext.request.contextPath}/uploads/${cate.icon}"
               alt="Icon hiện tại" width="120" height="120"/>
        </c:if>
      </div>

      <div class="form-group">
        <label for="icon">Ảnh mới:</label>
        <input type="file" id="icon" name="icon"/>
      </div>

      <button type="submit">Cập nhật</button>
      <a href="${pageContext.request.contextPath}/admin/category/list" class="btn-reset">Quay lại</a>
    </form>
  </div>
</body>
</html>
