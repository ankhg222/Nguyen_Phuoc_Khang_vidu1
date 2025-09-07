<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
    <style>
        .form-box {
            width: 400px;
            margin: 30px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.1);
            padding: 20px 26px;
            font-family: Arial, sans-serif;
        }
        .form-box h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-box label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }
        .form-box input[type="text"],
        .form-box input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }
        .form-box button {
            padding: 10px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        .btn-save {
            background: #0b7ac9;
            color: #fff;
        }
        .btn-reset {
            background: #ccc;
            margin-left: 8px;
        }
    </style>
</head>
<body>
<div class="form-box">
    <h2>Thêm danh mục</h2>
   <form action="${pageContext.request.contextPath}/category/add" 
      method="post" enctype="multipart/form-data">

    <label for="name">Tên danh mục:</label>
    <input type="text" id="name" name="name" required>

    <label for="icon">Ảnh đại diện:</label>
    <input type="file" id="icon" name="icon" accept="image/*" required>

    <button type="submit">Lưu</button>
    <button type="reset">Reset</button>
</form>
</div>
</body>
</html>
