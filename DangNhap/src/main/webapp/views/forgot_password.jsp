<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <style>
        body {
            background: #191f25;
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        .forgot-container {
            width: 340px;
            margin: 70px auto;
            background: #fff;
            border-radius: 14px;
            box-shadow: 0 6px 24px rgba(0,0,0,0.13);
            padding: 34px 28px 28px 28px;
        }
        .forgot-container h2 {
            text-align: center;
            margin-bottom: 26px;
            color: #191f25;
            letter-spacing: 1px;
        }
        .forgot-container label {
            font-size: 15px;
            display: block;
            margin-bottom: 6px;
        }
        .forgot-container input[type="text"],
        .forgot-container input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 18px;
            border: 1px solid #d1d1d1;
            border-radius: 8px;
            font-size: 15px;
            box-sizing: border-box;
        }
        .forgot-container button {
            width: 100%;
            padding: 12px;
            background: #0b7ac9;
            color: #fff;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            margin-bottom: 12px;
            transition: background 0.25s;
        }
        .forgot-container button:hover {
            background: #055e9c;
        }
        .forgot-container .alert-error {
            color: #e63946;
            text-align: center;
            margin-bottom: 10px;
            font-size: 15px;
        }
        .forgot-container .alert-success {
            color: #1a7f37;
            text-align: center;
            margin-bottom: 10px;
            font-size: 15px;
        }
        .forgot-container .back-link {
            text-align: right;
            font-size: 14px;
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

        <label for="newPassword">Mật khẩu mới:</label>
        <input type="password" id="newPassword" name="newPassword" required>

        <button type="submit">Đổi mật khẩu</button>
    </form>

    <c:if test="${not empty error}">
        <div class="alert-error">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="alert-success">${message}</div>
    </c:if>

    <div class="back-link">
