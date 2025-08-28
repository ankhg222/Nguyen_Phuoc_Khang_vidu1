<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng ký tài khoản</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Tạo tài khoản mới</h2>

<c:if test="${alert != null}">
    <c:choose>
        <c:when test="${alert == 'Đăng ký thành công!'}">
            <h3 style="color:green">${alert}</h3>
        </c:when>
        <c:otherwise>
            <h3 style="color:red">${alert}</h3>
        </c:otherwise>
    </c:choose>
</c:if>

<form action="register" method="post">
    <label>Tài khoản:</label>
    <input type="text" name="username"><br>

    <label>Mật khẩu:</label>
    <input type="password" name="password"><br>

    <label>Email:</label>
    <input type="email" name="email"><br>

    <label>Họ tên:</label>
    <input type="text" name="fullname"><br>

    <label>Số điện thoại:</label>
    <input type="text" name="phone"><br>

    <button type="submit">Đăng ký</button>
</form>
</body>
</html>
