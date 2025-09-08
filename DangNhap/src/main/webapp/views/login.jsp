<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        body {
		    background: #ffffff; /* hoặc dùng background: #fff; */
		    font-family: 'Segoe UI', Arial, sans-serif;
		}

        .login-box {
            width: 340px;
            margin: 70px auto;
            background: #fff;
            border-radius: 14px;
            box-shadow: 0 6px 24px rgba(0,0,0,0.13);
            padding: 34px 28px 28px 28px;
        }
        .login-box h2 {
            text-align: center;
            margin-bottom: 24px;
            color: #191f25;
            letter-spacing: 1px;
        }
        .login-box input[type="text"],
        .login-box input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #d1d1d1;
            border-radius: 8px;
            font-size: 15px;
            box-sizing: border-box;
        }
        .login-box label {
            font-size: 15px;
        }
        .login-box .remember-row {
            margin-bottom: 14px;
        }
        .login-box button {
            width: 100%;
            padding: 12px;
            background: #0062ff;
            color: #fff;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            font-weight: 600;
            transition: background 0.25s;
            margin-bottom: 10px;
        }
        .login-box button:hover {
            background: #004bb5;
        }
        .login-box .forgot-link {
            display: block;
            text-align: right;
            font-size: 14px;
            margin-top: 5px;
        }
        .login-box .forgot-link a {
            color: #0062ff;
            text-decoration: none;
        }
        .login-box .forgot-link a:hover {
            text-decoration: underline;
        }
        .login-box .alert {
            color: #e63946;
            text-align: center;
            margin-bottom: 10px;
            font-size: 15px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Đăng nhập</h2>

    <!-- Hiển thị thông báo -->
    <% String alert = (String) request.getAttribute("alert");
       if (alert != null) { %>
        <div class="alert"><%= alert %></div>
    <% } %>

    <form action="login" method="post">
    <label for="username">Tài khoản:</label>
    <input type="text" id="username" name="username"
           value="${savedUser != null ? savedUser : ''}" required>

    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required>

    <div class="remember-row">
        <input type="checkbox" id="remember" name="remember"
               <c:if test="${savedUser != null}">checked</c:if> >
        <label for="remember">Nhớ tôi</label>
    </div>

    <button type="submit">Đăng nhập</button>
	    <!-- Nút / link đăng ký -->
	<div style="text-align:center; margin-top:10px;">
	    <a href="${pageContext.request.contextPath}/register"
	       style="display:inline-block; padding:10px 16px; background:#28a745; color:#fff;
	              border-radius:8px; text-decoration:none; font-weight:600;">
	        Đăng ký tài khoản
	    </a>
	</div>
    <div class="forgot-link">
        <a href="${pageContext.request.contextPath}/forgot_password">Quên mật khẩu?</a>
    </div>
</form>

</div>
</body>
</html>
