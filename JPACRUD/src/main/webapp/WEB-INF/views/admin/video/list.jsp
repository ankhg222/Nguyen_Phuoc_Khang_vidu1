<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Video - Admin</title></head>
<body>
  <h2>Video - Admin</h2>

  <form method="get">
    <input type="text" name="q" value="${q}" placeholder="Tìm tiêu đề/mô tả...">
    <select name="categoryId">
      <option value="">--All Categories--</option>
      <c:forEach var="c" items="${categories}">
        <option value="${c.id}" ${categoryId != null && categoryId == c.id ? 'selected' : ''}>${c.name}</option>
      </c:forEach>
    </select>
    <button type="submit">Search</button>
    <a href="${pageContext.request.contextPath}/admin/videos?action=create">+ New</a>
  </form>

  <table border="1" cellspacing="0" cellpadding="5">
    <tr>
      <th>ID</th><th>Title</th><th>Category</th><th>Uploader</th><th>Actions</th>
    </tr>
    <c:forEach var="v" items="${items}">
      <tr>
        <td>${v.id}</td>
        <td>${v.title}</td>
        <td>${v.category != null ? v.category.name : ''}</td>
        <td>${v.uploader != null ? v.uploader.username : ''}</td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/videos?action=edit&id=${v.id}">Edit</a>
          |
          <a href="${pageContext.request.contextPath}/admin/videos?action=delete&id=${v.id}" onclick="return confirm('Xóa video này?')">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>

  <div>
    <c:forEach var="i" begin="0" end="${pages-1}">
      <c:choose>
        <c:when test="${i == page}">
          <b>[${i+1}]</b>
        </c:when>
        <c:otherwise>
          <a href="?q=${q}&categoryId=${categoryId}&page=${i}">${i+1}</a>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </div>
</body>
</html>
