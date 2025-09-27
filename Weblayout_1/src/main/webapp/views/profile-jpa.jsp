<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile Update bằng JPA - Profile Management System</title>
    <style>
        .profile-header {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            padding: 2rem 0;
            margin-bottom: 2rem;
            border-radius: 10px;
        }
        .profile-avatar {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border: 5px solid white;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }
        .profile-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
            border: none;
        }
        .btn-update {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            border: none;
            padding: 12px 30px;
            border-radius: 25px;
            font-weight: 600;
        }
        .student-info {
            background: #f8f9fa;
            padding: 1rem;
            border-left: 4px solid #28a745;
            margin-bottom: 2rem;
        }
        .jpa-badge {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 20px;
            font-weight: 600;
        }
    </style>
</head>
<body>
    <div class="container py-4">
        <!-- Student Info Header -->
        <div class="student-info">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <h5 class="mb-1">
                        <i class="fas fa-user-graduate"></i> Thông tin sinh viên
                        <span class="jpa-badge ms-3">
                            <i class="fas fa-database me-1"></i>JPA Mode
                        </span>
                    </h5>
                    <p class="mb-0"><strong>Họ tên:</strong> Nguyễn Phước Khang | <strong>MSSV:</strong> 23110236</p>
                </div>
                <div class="col-md-4 text-md-end">
                    <small class="text-muted">Bài tập: Profile Update với JPA/Hibernate</small>
                </div>
            </div>
        </div>

        <!-- Technology Comparison -->
        <div class="row mb-4">
            <div class="col-md-6">
                <div class="card border-primary">
                    <div class="card-header bg-primary text-white">
                        <h6 class="mb-0"><i class="fas fa-database me-2"></i>JDBC Version</h6>
                    </div>
                    <div class="card-body">
                        <p class="mb-2">Sử dụng JDBC truyền thống với SQL thuần</p>
                        <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary btn-sm">
                            <i class="fas fa-arrow-right me-1"></i>Chuyển sang JDBC
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card border-success">
                    <div class="card-header bg-success text-white">
                        <h6 class="mb-0"><i class="fas fa-layer-group me-2"></i>JPA Version (Hiện tại)</h6>
                    </div>
                    <div class="card-body">
                        <p class="mb-2">Sử dụng JPA/Hibernate ORM</p>
                        <span class="badge bg-success">Đang sử dụng</span>
                    </div>
                </div>
            </div>
        </div>

        <!-- Profile Header -->
        <div class="profile-header text-center">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-4">
                        <c:choose>
                            <c:when test="${not empty user.avatar}">
                                <img src="${pageContext.request.contextPath}/uploads/${user.avatar}" 
                                     class="profile-avatar rounded-circle mx-auto d-block" alt="Avatar">
                            </c:when>
                            <c:otherwise>
                                <div class="profile-avatar rounded-circle mx-auto d-block bg-light d-flex align-items-center justify-content-center">
                                    <i class="fas fa-user fa-4x text-muted"></i>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-md-8 text-md-start">
                        <h2 class="mb-2">
                            ${not empty user.fullname ? user.fullname : user.username}
                            <small class="badge bg-success ms-2">JPA</small>
                        </h2>
                        <p class="mb-1"><i class="fas fa-user me-2"></i>Username: ${user.username}</p>
                        <p class="mb-1"><i class="fas fa-envelope me-2"></i>Email: ${user.email}</p>
                        <c:if test="${not empty user.phone}">
                            <p class="mb-0"><i class="fas fa-phone me-2"></i>Phone: ${user.phone}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <!-- Alert Messages -->
        <c:if test="${not empty success}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <i class="fas fa-check-circle me-2"></i>${success}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <i class="fas fa-exclamation-circle me-2"></i>${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>

        <!-- Profile Update Form -->
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card profile-card">
                    <div class="card-header bg-transparent border-0 pb-0">
                        <h4 class="card-title mb-0">
                            <i class="fas fa-layer-group me-2 text-success"></i>Cập nhật Profile với JPA
                        </h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="${pageContext.request.contextPath}/profile-jpa" method="post" 
                              enctype="multipart/form-data" id="profileForm">
                            
                            <!-- Fullname -->
                            <div class="mb-4">
                                <label for="fullName" class="form-label fw-bold">
                                    <i class="fas fa-user me-2 text-success"></i>Họ và tên *
                                </label>
                                <input type="text" id="fullName" name="fullName" 
                                       class="form-control form-control-lg" 
                                       value="${user.fullname}" 
                                       required 
                                       placeholder="Nhập họ và tên đầy đủ">
                                <div class="form-text">Cập nhật bằng JPA EntityManager</div>
                            </div>

                            <!-- Phone -->
                            <div class="mb-4">
                                <label for="phone" class="form-label fw-bold">
                                    <i class="fas fa-phone me-2 text-success"></i>Số điện thoại
                                </label>
                                <input type="tel" id="phone" name="phone" 
                                       class="form-control form-control-lg" 
                                       value="${user.phone}" 
                                       placeholder="Nhập số điện thoại (tùy chọn)"
                                       pattern="[0-9]{10,11}">
                                <div class="form-text">Hibernate sẽ tự động quản lý transaction</div>
                            </div>

                            <!-- Avatar Upload -->
                            <div class="mb-4">
                                <label class="form-label fw-bold">
                                    <i class="fas fa-camera me-2 text-success"></i>Ảnh đại diện
                                </label>
                                
                                <div class="row mb-3">
                                    <div class="col-md-3">
                                        <div class="text-center">
                                            <c:choose>
                                                <c:when test="${not empty user.avatar}">
                                                    <img id="currentAvatar" 
                                                         src="${pageContext.request.contextPath}/uploads/${user.avatar}" 
                                                         class="img-thumbnail rounded-circle" 
                                                         width="120" height="120" 
                                                         style="object-fit: cover;" alt="Current Avatar">
                                                    <small class="d-block text-muted mt-1">Ảnh hiện tại</small>
                                                </c:when>
                                                <c:otherwise>
                                                    <div id="currentAvatar" 
                                                         class="bg-light rounded-circle d-flex align-items-center justify-content-center"
                                                         style="width: 120px; height: 120px; margin: 0 auto;">
                                                        <i class="fas fa-user fa-3x text-muted"></i>
                                                    </div>
                                                    <small class="d-block text-muted mt-1">Chưa có ảnh</small>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <input type="file" id="image" name="image" 
                                               class="form-control"
                                               accept=".jpg,.jpeg,.png,.gif"
                                               onchange="previewImage(this);">
                                        <small class="text-muted">File sẽ được lưu và path được persist qua JPA</small>
                                        
                                        <!-- Preview new image -->
                                        <div id="imagePreview" style="display: none;" class="mt-3">
                                            <img id="newImagePreview" class="img-thumbnail rounded" width="120" height="120" style="object-fit: cover;">
                                            <small class="d-block text-success mt-1">Ảnh mới được chọn</small>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Submit Button -->
                            <div class="text-center pt-3">
                                <button type="submit" class="btn btn-update btn-lg text-white">
                                    <i class="fas fa-layer-group me-2"></i>Cập nhật với JPA
                                </button>
                                <a href="${pageContext.request.contextPath}/profile" class="btn btn-outline-primary btn-lg ms-3">
                                    <i class="fas fa-database me-2"></i>Chuyển sang JDBC
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Technology Details -->
        <div class="row mt-4">
            <div class="col-12">
                <div class="card">
                    <div class="card-header bg-success text-white">
                        <h6 class="mb-0"><i class="fas fa-info-circle me-2"></i>Chi tiết kỹ thuật JPA Implementation</h6>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <h6><i class="fas fa-layer-group text-success me-2"></i>JPA/Hibernate Features:</h6>
                                <ul class="list-unstyled">
                                    <li><i class="fas fa-check text-success me-2"></i>EntityManager để quản lý entities</li>
                                    <li><i class="fas fa-check text-success me-2"></i>Transaction tự động với begin/commit/rollback</li>
                                    <li><i class="fas fa-check text-success me-2"></i>Object-Relational Mapping (ORM)</li>
                                    <li><i class="fas fa-check text-success me-2"></i>Lazy loading và caching</li>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <h6><i class="fas fa-database text-primary me-2"></i>So sánh với JDBC:</h6>
                                <ul class="list-unstyled">
                                    <li><i class="fas fa-arrow-right text-info me-2"></i>JDBC: SQL thuần, control nhiều hơn</li>
                                    <li><i class="fas fa-arrow-right text-success me-2"></i>JPA: ORM, code ngắn gọn hơn</li>
                                    <li><i class="fas fa-arrow-right text-warning me-2"></i>Performance: JDBC nhanh hơn, JPA tiện hơn</li>
                                    <li><i class="fas fa-arrow-right text-danger me-2"></i>Learning curve: JPA phức tạp hơn</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function previewImage(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    document.getElementById('newImagePreview').src = e.target.result;
                    document.getElementById('imagePreview').style.display = 'block';
                };
                reader.readAsDataURL(input.files[0]);
            }
        }

        // Form validation
        document.getElementById('profileForm').addEventListener('submit', function(e) {
            var fullName = document.getElementById('fullName').value.trim();
            if (fullName.length < 2) {
                e.preventDefault();
                alert('Họ tên phải có ít nhất 2 ký tự!');
                return;
            }
            
            var phone = document.getElementById('phone').value.trim();
            if (phone && !/^[0-9]{10,11}$/.test(phone)) {
                e.preventDefault();
                alert('Số điện thoại phải là 10-11 chữ số!');
                return;
            }
        });
    </script>
</body>
</html>