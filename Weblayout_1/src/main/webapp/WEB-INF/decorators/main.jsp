<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><sitemesh:write property='title'>Profile System - Nguyễn Phước Khang - 23110236</sitemesh:write></title>
    
    <!-- Bootstrap 5.3.2 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        .navbar-brand { font-weight: 600; }
        .main-content { min-height: calc(100vh - 180px); }
        .footer { background-color: #f8f9fa; border-top: 1px solid #e9ecef; }
        .profile-avatar { width: 40px; height: 40px; object-fit: cover; }
    </style>
    
    <sitemesh:write property='head'/>
</head>
<body class="bg-light">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <i class="fas fa-user-graduate me-2"></i>
                Profile System - Nguyễn Phước Khang (23110236)
            </a>
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">
                            <i class="fas fa-home me-1"></i>Trang chủ
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button" data-bs-toggle="dropdown">
                            <i class="fas fa-user me-1"></i>Profile
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">
                                <i class="fas fa-database me-2"></i>Profile (JDBC)
                            </a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile-jpa">
                                <i class="fas fa-layer-group me-2"></i>Profile (JPA)
                            </a></li>
                        </ul>
                    </li>
                </ul>
                
                <ul class="navbar-nav">
                    <c:if test="${sessionScope.account != null}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown">
                                <c:choose>
                                    <c:when test="${sessionScope.account.avatar != null && !empty sessionScope.account.avatar}">
                                        <img src="${pageContext.request.contextPath}/uploads/${sessionScope.account.avatar}" 
                                             class="profile-avatar rounded-circle me-2" alt="Avatar">
                                    </c:when>
                                    <c:otherwise>
                                        <i class="fas fa-user-circle me-2 fs-5"></i>
                                    </c:otherwise>
                                </c:choose>
                                ${sessionScope.account.fullname != null ? sessionScope.account.fullname : sessionScope.account.username}
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">
                                    <i class="fas fa-user me-2"></i>Thông tin cá nhân
                                </a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                                    <i class="fas fa-sign-out-alt me-2"></i>Đăng xuất
                                </a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.account == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login">
                                <i class="fas fa-sign-in-alt me-1"></i>Đăng nhập
                            </a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
        <sitemesh:write property='body'/>
    </div>

    <!-- Footer -->
    <footer class="footer py-4 mt-5">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h6 class="text-primary">Thông tin sinh viên:</h6>
                    <p class="mb-1"><strong>Họ tên:</strong> Nguyễn Phước Khang</p>
                    <p class="mb-1"><strong>MSSV:</strong> 23110236</p>
                </div>
                <div class="col-md-6 text-md-end">
                    <p class="mb-1"><strong>Bài tập:</strong> Sitemesh Decorator 3 với Bootstrap</p>
                    <p class="mb-1"><strong>Chức năng:</strong> Profile Update với File Upload (JDBC/JPA)</p>
                </div>
            </div>
            <hr>
            <div class="text-center">
                <small class="text-muted">© 2025 Profile Management System - Nguyễn Phước Khang (23110236)</small>
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <sitemesh:write property='javascript'/>
</body>
</html>