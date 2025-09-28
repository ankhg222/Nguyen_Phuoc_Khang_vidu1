<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Cài đặt tài khoản</title>
    <meta name="decorator" content="admin">
</head>
<body>
    <div class="row">
        <div class="col-md-8 mx-auto">
            <!-- Alert Messages -->
            <c:if test="${not empty message}">
                <div class="alert alert-${alertType} alert-dismissible fade show" role="alert">
                    ${message}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </c:if>

            <div class="card">
                <div class="card-header">
                    <h5 class="card-title mb-0">
                        <i class="bi bi-person-gear"></i> Cài đặt tài khoản
                    </h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <!-- Avatar Section -->
                        <div class="col-md-4 text-center mb-4">
                            <div class="mb-3">
                                <img id="avatarPreview" 
                                     src="${pageContext.request.contextPath}/uploads/${not empty user.images ? user.images : 'default-avatar.jpg'}" 
                                     class="rounded-circle img-thumbnail" 
                                     style="width: 150px; height: 150px; object-fit: cover;"
                                     alt="Avatar">
                            </div>
                            <h6 class="fw-bold">${user.fullname}</h6>
                            <p class="text-muted small">@${user.username}</p>
                        </div>

                        <!-- Profile Form -->
                        <div class="col-md-8">
                            <form method="post" action="${pageContext.request.contextPath}/admin/profile/update" 
                                  enctype="multipart/form-data">
                                
                                <!-- Username (Read-only) -->
                                <div class="mb-3">
                                    <label class="form-label fw-bold">
                                        <i class="bi bi-person"></i> Tên đăng nhập
                                    </label>
                                    <input type="text" class="form-control" value="${user.username}" readonly>
                                    <small class="text-muted">Tên đăng nhập không thể thay đổi</small>
                                </div>

                                <!-- Email (Read-only) -->
                                <div class="mb-3">
                                    <label class="form-label fw-bold">
                                        <i class="bi bi-envelope"></i> Email
                                    </label>
                                    <input type="email" class="form-control" value="${user.email}" readonly>
                                    <small class="text-muted">Email không thể thay đổi</small>
                                </div>

                                <!-- Full Name -->
                                <div class="mb-3">
                                    <label class="form-label fw-bold">
                                        <i class="bi bi-card-text"></i> Họ và tên <span class="text-danger">*</span>
                                    </label>
                                    <input type="text" class="form-control" name="fullname" 
                                           value="${user.fullname}" required 
                                           placeholder="Nhập họ và tên đầy đủ">
                                </div>

                                <!-- Phone -->
                                <div class="mb-3">
                                    <label class="form-label fw-bold">
                                        <i class="bi bi-phone"></i> Số điện thoại
                                    </label>
                                    <input type="tel" class="form-control" name="phone" 
                                           value="${user.phone}" 
                                           placeholder="Nhập số điện thoại"
                                           pattern="[0-9]{10,11}">
                                    <small class="text-muted">Định dạng: 10-11 chữ số</small>
                                </div>

                                <!-- Avatar Upload -->
                                <div class="mb-4">
                                    <label class="form-label fw-bold">
                                        <i class="bi bi-image"></i> Ảnh đại diện
                                    </label>
                                    <input type="file" class="form-control" name="imageFile" 
                                           id="imageFile" accept="image/*">
                                    <small class="text-muted">
                                        Chọn file ảnh (JPG, PNG, GIF). Tối đa 10MB
                                    </small>
                                </div>

                                <!-- Action Buttons -->
                                <div class="d-flex gap-2">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="bi bi-check-circle"></i> Cập nhật
                                    </button>
                                    <button type="reset" class="btn btn-secondary">
                                        <i class="bi bi-arrow-clockwise"></i> Đặt lại
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Account Info Card -->
            <div class="card mt-4">
                <div class="card-header">
                    <h6 class="card-title mb-0">
                        <i class="bi bi-info-circle"></i> Thông tin tài khoản
                    </h6>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>ID:</strong> ${user.id}</p>
                            <p><strong>Vai trò:</strong> 
                                <span class="badge bg-primary">
                                    ${user.roleid == 1 ? 'Admin' : 'User'}
                                </span>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Trạng thái:</strong> 
                                <span class="badge ${user.active ? 'bg-success' : 'bg-danger'}">
                                    ${user.active ? 'Hoạt động' : 'Vô hiệu hóa'}
                                </span>
                            </p>
                            <p><strong>Ngày tạo:</strong> ${user.createDate}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Custom Scripts -->
    <content tag="page.script">
        <script>
            // Preview avatar when file is selected
            document.getElementById('imageFile').addEventListener('change', function(event) {
                const file = event.target.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        document.getElementById('avatarPreview').src = e.target.result;
                    };
                    reader.readAsDataURL(file);
                }
            });

            // Form validation
            document.querySelector('form').addEventListener('submit', function(event) {
                const fullname = document.querySelector('input[name="fullname"]').value.trim();
                
                if (!fullname) {
                    alert('Vui lòng nhập họ và tên!');
                    event.preventDefault();
                    return false;
                }

                const phone = document.querySelector('input[name="phone"]').value.trim();
                if (phone && !/^[0-9]{10,11}$/.test(phone)) {
                    alert('Số điện thoại phải có 10-11 chữ số!');
                    event.preventDefault();
                    return false;
                }

                return true;
            });

            // Auto-hide alerts after 5 seconds
            setTimeout(function() {
                const alerts = document.querySelectorAll('.alert');
                alerts.forEach(function(alert) {
                    const bsAlert = new bootstrap.Alert(alert);
                    bsAlert.close();
                });
            }, 5000);
        </script>
    </content>
</body>
</html>