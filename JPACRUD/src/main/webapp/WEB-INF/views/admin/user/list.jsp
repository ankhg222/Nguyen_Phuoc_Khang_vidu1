<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>User - Admin</title></head>
<body>
  <h2>User - Admin</h2>

  <form method="get">
    <input type="text" name="q" value="${q}" placeholder="Tìm username/email...">
    <button type="submit">Search</button>
    <a href="${pageContext.request.contextPath}/admin/users?action=create">+ New</a>
  </form>

  <table border="1" cellspacing="0" cellpadding="5">
    <tr>
      <th>ID</th><th>Username</th><th>Email</th><th>Role</th><th>Active</th><th>Actions</th>
    </tr>
    <c:forEach var="u" items="${items}">
      <tr>
        <td>${u.id}</td>
        <td>${u.username}</td>
        <td>${u.email}</td>
        <td>${u.role}</td>
        <td>${u.active}</td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/users?action=edit&id=${u.id}">Edit</a>
          |
          <a href="${pageContext.request.contextPath}/admin/users?action=delete&id=${u.id}" onclick="return confirm('Xóa user này?')">Delete</a>
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
          <a href="?q=${q}&page=${i}">${i+1}</a>
        </c:otherwise>
      </c:choose>
    </c:forEach>
  </div>
</body>
</html>
