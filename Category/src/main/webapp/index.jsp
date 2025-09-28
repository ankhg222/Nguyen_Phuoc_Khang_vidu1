<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Trang chủ - Admin Panel</title>
    <meta name="decorator" content="web">
</head>
<body>
    <div class="text-center mb-5">
        <h1 class="display-4"><i class="bi bi-speedometer2"></i> Admin Panel</h1>
        <p class="lead">Hệ thống quản lý danh mục và video với SiteMesh Decorator 3</p>
    </div>

    <!-- Quick Actions -->
    <div class="row justify-content-center">
        <div class="col-md-4 mb-3">
            <div class="card text-center">
                <div class="card-body">
                    <i class="bi bi-tags display-4 text-primary mb-3"></i>
                    <h5 class="card-title">Quản lý danh mục</h5>
                    <p class="card-text">Thêm, sửa, xóa danh mục</p>
                    <a href="${pageContext.request.contextPath}/admin/category" class="btn btn-primary">
                        <i class="bi bi-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <div class="card text-center">
                <div class="card-body">
                    <i class="bi bi-person-gear display-4 text-success mb-3"></i>
                    <h5 class="card-title">Cài đặt tài khoản</h5>
                    <p class="card-text">Cập nhật profile và thông tin</p>
                    <a href="${pageContext.request.contextPath}/admin/profile" class="btn btn-success">
                        <i class="bi bi-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
        </div>

        <div class="col-md-4 mb-3">
            <div class="card text-center">
                <div class="card-body">
                    <i class="bi bi-info-circle display-4 text-info mb-3"></i>
                    <h5 class="card-title">Thông tin hệ thống</h5>
                    <p class="card-text">Java Servlet + JSP + Bootstrap</p>
                    <button class="btn btn-info" disabled>
                        <i class="bi bi-check-circle"></i> Hoạt động
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Status Info -->
    <div class="row mt-5">
        <div class="col-12">
            <div class="alert alert-success text-center">
                <h4><i class="bi bi-check-circle"></i> Hệ thống đã sẵn sàng!</h4>
                <p class="mb-0">Bạn có thể bắt đầu sử dụng các chức năng quản lý.</p>
            </div>
        </div>
    </div>

    <!-- Statistics -->
    <div class="row mt-4">
        <div class="col-md-3">
            <div class="card bg-primary text-white text-center">
                <div class="card-body">
                    <h5>Danh mục</h5>
                    <h2>${not empty categoryCount ? categoryCount : 0}</h2>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card bg-success text-white text-center">
                <div class="card-body">
                    <h5>Video</h5>
                    <h2>${not empty videoCount ? videoCount : 0}</h2>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card bg-info text-white text-center">
                <div class="card-body">
                    <h5>Người dùng</h5>
                    <h2>${not empty userCount ? userCount : 1}</h2>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card bg-warning text-dark text-center">
                <div class="card-body">
                    <h5>Trạng thái</h5>
                    <h2><i class="bi bi-check-circle"></i></h2>
                </div>
            </div>
        </div>
    </div>
</body>
</html>