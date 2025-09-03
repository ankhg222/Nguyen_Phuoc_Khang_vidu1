<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            background: #fff;
            max-width: 380px;
            margin: 80px auto;
            border-radius: 14px;
            box-shadow: 0 2px 16px rgba(0,0,0,0.10);
            padding: 32px 32px 24px 32px;
            text-align: center;
        }
        h2 {
            margin-bottom: 18px;
            color: #1a73e8;
        }
        p {
            margin-bottom: 28px;
            font-size: 1.08em;
            color: #222;
        }
        .btn {
            display: inline-block;
            margin: 8px 12px;
            padding: 10px 24px;
            font-size: 1em;
            border: none;
            border-radius: 7px;
            background: #1a73e8;
            color: #fff;
            text-decoration: none;
            cursor: pointer;
            transition: background 0.18s;
        }
        .btn:hover {
            background: #1763c6;
        }
        .actions {
            margin-top: 12px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Đăng nhập thành công!</h2>
        <p>Xin chào, <b>${sessionScope.account.username}</b></p>
        <div class="actions">
            <a href="${pageContext.request.contextPath}/logout" class="btn">Đăng xuất</a>
            <a href="${pageContext.request.contextPath}/category/list" class="btn">Quản lý Category</a>
        </div>
    </div>
</body>
</html>
