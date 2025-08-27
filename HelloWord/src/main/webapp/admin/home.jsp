<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Home</title></head>
<body>
<h2>Đăng nhập thành công!</h2>
<p>Xin chào, ${sessionScope.account.userName}</p>
<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>