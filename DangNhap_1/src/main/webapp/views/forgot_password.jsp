<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <style>
        body {
            background: #f5f6fa; /* nền sáng cho dịu mắt */
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        .forgot-container {
            width: 360px;
            margin: 70px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.1);
            padding: 30px 26px;
        }
        .forgot-container h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #222;
            font-size: 20px;
        }
        .forgot-container label {
            font-size: 14px;
            display: block;
            margin-bottom: 6px;
            font-weight: 500;
            color: #333;
        }
        .forgot-container input[type="text"],
        .forgot-container input[type="email"],
        .forgot-container input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: border-color 0.2s;
        }
        .forgot-container input:focus {
            outline: none;
            border-color: #0b7ac9;
            box-shadow: 0 0 4px rgba(11,122,201,0.3);
        }
        .forgot-container button {
            width: 100%;
            padding: 12px;
            background: #0b7ac9;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            margin-top: 4px;
            transition: background 0.25s;
        }
        .forgot-container button:hover {
            background: #055e9c;
        }
        .forgot-container .alert-error {
            color: #e63946;
            text-align: center;
            margin-bottom: 10px;
            font-size: 14px;
        }
        .forgot-container .alert-success {
            color: #1a7f37;
            text-align: center;
            margin-bottom: 10px;
            font-size: 14px;
        }
        .forgot-container .back-link {
            text-align: right;
            font-size: 13px;
            margin-top: 8px;
        }
        .forgot-container .back-link a {
            color: #0b7ac9;
            text-decoration: none;
        }
        .forgot-container .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="forgot-container">
    <h2>Đặt lại mật khẩu</h2>
    <form action="${pageContext.request.contextPath}/forgot_password" method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required>

        <label for="email">Gmail:</label>
        <input type="email" id="email" name="email" required>

        <label for="newPassword">Mật khẩu mới:</label>
        <input type="password" id="newPassword" name="newPassword" required>

        <label for="confirmPassword">Xác nhận mật khẩu:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <button type="submit">Đổi mật khẩu</button>
    </form>

    <c:if test="${not empty error}">
        <div class="alert-error">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="alert-success">${message}</div>
    </c:if>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
    </div>
</div>
</body>
</html>
