<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <style>
        body { font-family: Arial, sans-serif; background:#f9f9f9; }
        .register-box {
            width: 380px; margin: 60px auto; background:#fff; padding:28px;
            border-radius:10px; box-shadow: 0 4px 16px rgba(0,0,0,0.15);
        }
        h2 { text-align:center; color:#333; margin-bottom:20px; }
        input[type=text], input[type=password], input[type=email] {
            width:100%; padding:10px; margin-bottom:14px;
            border:1px solid #ccc; border-radius:6px; box-sizing:border-box;
        }
        button {
            width:100%; padding:12px; background:#0062ff; color:#fff;
            border:none; border-radius:6px; font-size:16px; font-weight:600;
        }
        button:hover { background:#004bb5; }
    </style>
</head>
<body>
<div class="register-box">
    <h2>Đăng ký tài khoản</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="text" name="fullname" placeholder="Họ và tên" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <input type="text" name="phone" placeholder="Số điện thoại" required>
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">Đăng ký</button>
    </form>
</div>
</body>
</html>
