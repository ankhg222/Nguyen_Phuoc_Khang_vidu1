<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <!-- Font Awesome CDN -->
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      display: flex;
      min-height: 100vh;
    }
    .content {
      flex: 1;
      padding: 20px;
      background: #f2f2f2;
    }
  </style>
</head>
<body>
  <!-- Sidebar -->
  <jsp:include page="/views/common/sidebar.jsp" />

  <!-- Nội dung -->
  <div class="content">
    <h2>Trang Dashboard</h2>
    <p>Xin chào, <b>${sessionScope.account.username}</b></p>
  </div>
</body>
</html>
