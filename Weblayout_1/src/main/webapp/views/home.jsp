<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ - Profile Management System</title>
</head>
<body>
    <div class="container py-5">
        <!-- Welcome Header -->
        <div class="row">
            <div class="col-12">
                <div class="bg-primary text-white rounded-4 p-5 mb-4">
                    <div class="row align-items-center">
                        <div class="col-lg-8">
                            <h1 class="display-5 fw-bold mb-3">
                                <i class="fas fa-home me-3"></i>Chào mừng đến với Profile Management System
                            </h1>
                            <p class="lead mb-0">
                                Hệ thống quản lý profile với Sitemesh Decorator 3, Bootstrap và tính năng upload file
                            </p>
                        </div>
                        <div class="col-lg-4 text-center">
                            <i class="fas fa-user-cog fa-5x opacity-50"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Student Information -->
        <div class="row mb-4">
            <div class="col-12">
                <div class="card border-primary">
                    <div class="card-header bg-primary text-white">
                        <h5 class="card-title mb-0">
                            <i class="fas fa-user-graduate me-2"></i>Thông tin sinh viên
                        </h5>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <p><strong><i class="fas fa-user me-2 text-primary"></i>Họ và tên:</strong> Nguyễn Phước Khang</p>
                                <p><strong><i class="fas fa-id-card me-2 text-primary"></i>Mã số sinh viên:</strong> 23110236</p>
                            </div>
                            <div class="col-md-6">
                                <p><strong><i class="fas fa-tasks me-2 text-primary"></i>Bài tập:</strong> Sitemesh Decorator 3 với Bootstrap Template</p>
                                <p><strong><i class="fas fa-cogs me-2 text-primary"></i>Chức năng:</strong> Profile Update với File Upload (JDBC/JPA)</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Database Implementation Comparison -->
        <div class="row mb-4">
            <div class="col-12">
                <h3 class="mb-4"><i class="fas fa-database me-2 text-info"></i>So sánh JDBC vs JPA Implementation</h3>
            </div>
            <div class="col-md-6 mb-3">
                <div class="card h-100 border-primary">
                    <div class="card-header bg-primary text-white">
                        <h5 class="mb-0"><i class="fas fa-database me-2"></i>JDBC Version</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled">
                            <li><i class="fas fa-check text-success me-2"></i>SQL thuần, control tốt</li>
                            <li><i class="fas fa-check text-success me-2"></i>Performance cao</li>
                            <li><i class="fas fa-check text-success me-2"></i>Dễ debug và optimize</li>
                            <li><i class="fas fa-check text-success me-2"></i>Connection pooling</li>
                        </ul>
                        <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary">
                            <i class="fas fa-arrow-right me-2"></i>Test JDBC Version
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <div class="card h-100 border-success">
                    <div class="card-header bg-success text-white">
                        <h5 class="mb-0"><i class="fas fa-layer-group me-2"></i>JPA/Hibernate Version</h5>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled">
                            <li><i class="fas fa-check text-success me-2"></i>ORM mapping tự động</li>
                            <li><i class="fas fa-check text-success me-2"></i>Code ngắn gọn hơn</li>
                            <li><i class="fas fa-check text-success me-2"></i>Transaction tự động</li>
                            <li><i class="fas fa-check text-success me-2"></i>Lazy loading & caching</li>
                        </ul>
                        <a href="${pageContext.request.contextPath}/profile-jpa" class="btn btn-success">
                            <i class="fas fa-arrow-right me-2"></i>Test JPA Version
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Features -->
        <div class="row mb-4">
            <div class="col-12">
                <h3 class="mb-4"><i class="fas fa-star me-2 text-warning"></i>Tính năng đã thực hiện</h3>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card h-100 border-0 shadow-sm">
                    <div class="card-body text-center">
                        <i class="fas fa-paint-brush fa-3x text-primary mb-3"></i>
                        <h5>Sitemesh Decorator 3</h5>
                        <p class="text-muted">Layout template với Bootstrap 5.3.2, hiển thị thông tin MSSV 23110236</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card h-100 border-0 shadow-sm">
                    <div class="card-body text-center">
                        <i class="fas fa-user-edit fa-3x text-success mb-3"></i>
                        <h5>Profile Update</h5>
                        <p class="text-muted">Cập nhật fullname, phone, images với validation đầy đủ</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="card h-100 border-0 shadow-sm">
                    <div class="card-body text-center">
                        <i class="fas fa-upload fa-3x text-info mb-3"></i>
                        <h5>Multipart File Upload</h5>
                        <p class="text-muted">Upload ảnh với validation type, size và unique filename</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Technology Stack -->
        <div class="row mb-4">
            <div class="col-12">
                <h3 class="mb-4"><i class="fas fa-code me-2 text-info"></i>Technology Stack</h3>
            </div>
            <div class="col-lg-6">
                <div class="card border-info">
                    <div class="card-header bg-info text-white">
                        <h6 class="card-title mb-0">Frontend Technologies</h6>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled">
                            <li><i class="fab fa-bootstrap text-purple me-2"></i>Bootstrap 5.3.2</li>
                            <li><i class="fab fa-font-awesome text-primary me-2"></i>Font Awesome Icons</li>
                            <li><i class="fas fa-code text-warning me-2"></i>JSP + JSTL</li>
                            <li><i class="fas fa-paint-brush text-success me-2"></i>Sitemesh 3.2.1</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="card border-success">
                    <div class="card-header bg-success text-white">
                        <h6 class="card-title mb-0">Backend Technologies</h6>
                    </div>
                    <div class="card-body">
                        <ul class="list-unstyled">
                            <li><i class="fab fa-java text-red me-2"></i>Java 22 + Jakarta EE</li>
                            <li><i class="fas fa-database text-primary me-2"></i>JDBC + JPA/Hibernate</li>
                            <li><i class="fas fa-server text-info me-2"></i>SQL Server Database</li>
                            <li><i class="fas fa-upload text-warning me-2"></i>Apache Commons FileUpload</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Quick Actions -->
        <div class="row">
            <div class="col-12">
                <div class="card bg-light">
                    <div class="card-body text-center">
                        <h5 class="card-title">Demo chức năng Profile Update</h5>
                        <p class="card-text text-muted">Chọn phiên bản để test: JDBC (truyền thống) hoặc JPA (ORM)</p>
                        
                        <div class="btn-group mb-3" role="group">
                            <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary btn-lg">
                                <i class="fas fa-database me-2"></i>Profile với JDBC
                            </a>
                            <a href="${pageContext.request.contextPath}/profile-jpa" class="btn btn-success btn-lg">
                                <i class="fas fa-layer-group me-2"></i>Profile với JPA
                            </a>
                        </div>
                        
                        <br>
                        
                        <c:if test="${sessionScope.account == null && sessionScope.userId == null}">
                            <div class="alert alert-warning">
                                <i class="fas fa-info-circle me-2"></i>
                                Bạn cần đăng nhập để test chức năng profile update
                                <br>
                                <a href="${pageContext.request.contextPath}/login" class="btn btn-warning mt-2">
                                    <i class="fas fa-sign-in-alt me-2"></i>Đăng nhập ngay
                                </a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <style>
        .text-purple { color: #6f42c1 !important; }
        .text-red { color: #dc3545 !important; }
        
        .card {
            transition: transform 0.2s ease-in-out;
        }
        
        .card:hover {
            transform: translateY(-5px);
        }
        
        .bg-primary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%) !important;
        }
    </style>
</body>
</html>
