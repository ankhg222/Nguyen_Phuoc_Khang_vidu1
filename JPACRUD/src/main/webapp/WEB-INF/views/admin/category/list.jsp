<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Category - Admin</title></head>
<body>
  <h2>Category - Admin</h2>

  <form method="get">
    <input type="text" name="q" value="${q}" placeholder="Tim kiem ten/mo ta...">
    <button type="submit">Search</button>
    <a href="${pageContext.request.contextPath}/admin/categories?action=create">+ New</a>
  </form>

  <table border="1" cellspacing="0" cellpadding="5">
    <tr>
      <th>ID</th><th>Name</th><th>Description</th><th>Active</th><th>Actions</th>
    </tr>
    <c:forEach var="c" items="${items}">
      <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.description}</td>
        <td><c:out value="${c.active}"/></td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/categories?action=edit&id=${c.id}">Edit</a>
          |
          <a href="${pageContext.request.contextPath}/admin/categories?action=delete&id=${c.id}" 
             onclick="return confirm('Xoa?')">Delete</a>
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
