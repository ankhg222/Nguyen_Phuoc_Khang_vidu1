<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Dang nhap</title></head>
<body>
  <h2>Dang nhap</h2>
  <form method="post" action="${pageContext.request.contextPath}/login">
    <label>User:</label><input name="username" required>
    <label>Password:</label><input name="password" type="password" required>
    <button type="submit">Login</button>
  </form>
  <p style="color:red">${error}</p>
</body>
</html>
