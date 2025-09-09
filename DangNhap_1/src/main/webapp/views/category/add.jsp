<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Thêm danh mục</title>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    body {margin:0;font-family:Arial, sans-serif;display:flex;min-height:100vh}
    .content {flex:1;padding:20px;background:#f2f2f2}
    form {background:#fff;padding:20px;border-radius:8px}
    label {display:block;margin-top:10px}
  </style>
</head>
<body>
  <jsp:include page="/views/common/sidebar.jsp" />

  <div class="content">
    <h2>Thêm danh mục mới</h2>
    <form action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
      <label>Tên danh mục:</label>
      <input type="text" name="name" required />

      <label>Ảnh đại diện:</label>
      <input type="file" name="icon" />

      <br/><br/>
      <button type="submit">Thêm</button>
      <button type="reset">Hủy</button>
    </form>
  </div>
</body>
</html>
