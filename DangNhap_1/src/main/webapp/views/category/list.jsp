<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách danh mục</title>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    body {margin:0;font-family:Arial, sans-serif;display:flex;min-height:100vh}
    .content {flex:1;padding:20px;background:#f2f2f2}
    table {width:100%;border-collapse:collapse;background:#fff}
    th, td {padding:10px;border:1px solid #ddd;text-align:center}
    th {background:#3498db;color:#fff}
  </style>
</head>
<body>
  <!-- Sidebar -->
  <jsp:include page="/views/common/sidebar.jsp" />

  <!-- Nội dung -->
  <div class="content">
    <h2>Danh sách danh mục</h2>
    <br/><br/>
    <table>
  <thead>
    <tr>
      <th>STT</th>
      <th>ID</th>
      <th>Tên danh mục</th>
      <th>Hình ảnh</th>
      <th>Hành động</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${cateList}" var="cate" varStatus="st">
      <tr>
        <td>${st.index + 1}</td>
        <td>${cate.cateId}</td>
        <td>${cate.cateName}</td>
        <td>
          <c:if test="${not empty cate.icon}">
            <img src="${pageContext.request.contextPath}/uploads/${cate.icon}" width="80" height="80"/>
          </c:if>
        </td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.cateId}">Sửa</a> |
          <a href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.cateId}" 
             onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
  </div>
</body>
</html>
