# 🚀 Admin Panel với SiteMesh Decorator 3 + Bootstrap 5

## 📋 Tổng quan dự án

Hệ thống quản lý danh mục và video được xây dựng với:
- **Backend**: Java Servlet + JSP
- **Template Engine**: SiteMesh 3
- **CSS Framework**: Bootstrap 5.3.3  
- **Database**: SQL Server với JPA/Hibernate
- **Upload**: Multipart form với Commons FileUpload

## 🎯 Các chức năng chính

### ✅ SiteMesh Decorator 3
- **admin.jsp**: Template cho admin panel với sidebar
- **web.jsp**: Template cho trang chủ 
- **user.jsp**: Template cho user pages

### ✅ Profile Management
- Cập nhật fullname, phone
- Upload avatar với preview
- Validation client & server side
- JPA operations với User entity

### ✅ Category Management  
- CRUD operations cho danh mục
- Bootstrap UI với responsive design

## 🛠️ Cách deploy

### 1. Chuẩn bị database
```sql
-- Chạy script trong database/create_users_table.sql
-- Tạo bảng users với dữ liệu mẫu
```

### 2. Build project
```bash
mvn clean package
```

### 3. Deploy lên Tomcat
1. Copy file `target/HelloWord-1.1.0.war` vào thư mục `[TOMCAT_HOME]/webapps/`
2. Start Tomcat server
3. Truy cập: `http://localhost:8080/HelloWord-1.1.0/`

## 🔗 Các URL chính

| Trang | URL | Mô tả |
|-------|-----|-------|
| 🏠 Trang chủ | `/HelloWord-1.1.0/` | Dashboard chính |
| 🧪 Test | `/HelloWord-1.1.0/test` | Kiểm tra servlet |
| 📂 Admin | `/HelloWord-1.1.0/admin` | Admin dashboard |  
| 📋 Categories | `/HelloWord-1.1.0/admin/category` | Quản lý danh mục |
| 👤 Profile | `/HelloWord-1.1.0/admin/profile` | Cài đặt tài khoản |

## 🏗️ Cấu trúc dự án

```
src/main/
├── java/vn/iot/
│   ├── controller/
│   │   ├── IndexController.java      # Root path handler
│   │   ├── HomeController.java       # Dashboard controller  
│   │   ├── CategoryServlet.java      # Category CRUD
│   │   ├── ProfileController.java    # Profile + upload
│   │   └── TestController.java       # Debug servlet
│   ├── dao/
│   │   ├── CategoryDAO.java          # Category operations
│   │   └── UserDAO.java              # User operations
│   └── entity/
│       ├── Category.java             # Category entity
│       ├── User.java                 # User entity  
│       └── Video.java                # Video entity
├── resources/META-INF/
│   └── persistence.xml               # JPA configuration
└── webapp/
    ├── decorators/
    │   ├── admin.jsp                 # Admin template
    │   ├── web.jsp                   # Web template
    │   └── user.jsp                  # User template
    ├── views/admin/
    │   ├── category-list.jsp         # Category management
    │   └── profile.jsp               # Profile management
    ├── uploads/                      # Upload directory
    ├── WEB-INF/
    │   ├── web.xml                   # Servlet configuration
    │   └── sitemesh3.xml             # SiteMesh mapping
    └── index.jsp                     # Home page
```

## 🔧 Cấu hình quan trọng

### SiteMesh Mapping (sitemesh3.xml)
```xml
<mapping path="/admin/*" decorator="/decorators/admin.jsp"/>
<mapping path="/user/*" decorator="/decorators/user.jsp"/>  
<mapping path="/*" decorator="/decorators/web.jsp"/>
```

### Servlet Mappings (web.xml)
- `/` → IndexController (redirect to /home)
- `/home`, `/admin` → HomeController
- `/admin/category/*` → CategoryServlet
- `/admin/profile/*` → ProfileController
- `/test` → TestController

## 🐛 Troubleshooting

### Lỗi 404 Not Found
1. Kiểm tra Tomcat đã start chưa
2. Đảm bảo WAR file đã deploy đúng
3. Thử truy cập `/HelloWord-1.1.0/test` để kiểm tra servlet

### Lỗi Database  
1. Kiểm tra connection string trong persistence.xml
2. Đảm bảo SQL Server đang chạy
3. Chạy script tạo bảng users

### Lỗi Upload File
1. Kiểm tra thư mục `uploads/` đã tồn tại
2. Đảm bảo có quyền ghi file
3. Kiểm tra kích thước file < 10MB

## 📞 Hỗ trợ

Nếu gặp vấn đề, hãy kiểm tra:
- Tomcat logs: `[TOMCAT_HOME]/logs/catalina.out`
- Browser console cho lỗi JavaScript
- Network tab cho HTTP errors

## 🎉 Kết luận

Dự án đã được cấu hình đầy đủ với SiteMesh Decorator 3, Bootstrap 5, và các chức năng profile management hoàn chỉnh. Hệ thống sẵn sàng để mở rộng thêm các chức năng khác!