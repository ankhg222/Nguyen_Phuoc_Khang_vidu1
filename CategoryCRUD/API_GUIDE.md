# Hướng dẫn sử dụng API và AJAX cho Category CRUD

## Tổng quan
Dự án đã được cập nhật với 2 cách quản lý Category:
1. **Thymeleaf Template** (truyền thống): `/admin/categories`
2. **AJAX + REST API** (hiện đại): `/ajax-categories`

## REST API Endpoints

### Base URL: `/api/categories`

### 1. Lấy danh sách categories (có phân trang)
```
GET /api/categories?page=0&size=10&search=keyword
```

**Response:**
```json
{
  "success": true,
  "message": "Lấy danh sách categories thành công",
  "data": {
    "content": [
      {
        "id": 1,
        "name": "Electronics",
        "image": "https://example.com/image.jpg",
        "active": true,
        "createdAt": "2024-01-01T10:00:00"
      }
    ],
    "totalElements": 1,
    "totalPages": 1,
    "number": 0,
    "size": 10,
    "first": true,
    "last": true
  }
}
```

### 2. Lấy category theo ID
```
GET /api/categories/{id}
```

### 3. Tạo category mới
```
POST /api/categories
Content-Type: application/json

{
  "name": "New Category",
  "image": "https://example.com/image.jpg",
  "active": true
}
```

### 4. Cập nhật category
```
PUT /api/categories/{id}
Content-Type: application/json

{
  "name": "Updated Category",
  "image": "https://example.com/new-image.jpg",
  "active": false
}
```

### 5. Xóa category
```
DELETE /api/categories/{id}
```

### 6. Lấy tất cả categories (không phân trang)
```
GET /api/categories/all
```

## Cách sử dụng

### 1. Truy cập trang AJAX
- Mở trình duyệt và truy cập: `http://localhost:8080/ajax-categories`
- Hoặc từ trang chủ: `http://localhost:8080/` → click "Quản lý Category (AJAX)"

### 2. Tính năng có sẵn
- ✅ **Xem danh sách** với phân trang
- ✅ **Tìm kiếm** theo tên category
- ✅ **Thêm mới** category
- ✅ **Chỉnh sửa** category
- ✅ **Xóa** category với xác nhận
- ✅ **Validation** dữ liệu đầu vào
- ✅ **Loading states** và error handling
- ✅ **Responsive design** với Bootstrap

### 3. So sánh 2 cách tiếp cận

| Tính năng | Thymeleaf | AJAX |
|-----------|-----------|------|
| Tốc độ tải trang | Chậm (reload) | Nhanh (không reload) |
| UX | Cơ bản | Hiện đại |
| Validation | Server-side | Client + Server |
| Error handling | Redirect | Inline messages |
| Responsive | Có | Có |
| SEO | Tốt | Kém |

## Cấu trúc code

### DTO Classes
- `CategoryRequest.java`: Dữ liệu đầu vào
- `CategoryResponse.java`: Dữ liệu trả về
- `ApiResponse.java`: Wrapper cho response

### API Controller
- `CategoryApiController.java`: Xử lý các REST endpoints

### Frontend
- `ajax-list.html`: Giao diện AJAX với JavaScript

## Lưu ý kỹ thuật

1. **CORS**: API đã được cấu hình `@CrossOrigin(origins = "*")` để cho phép truy cập từ mọi domain
2. **Validation**: Sử dụng `@Valid` và `@NotBlank` cho validation
3. **Error Handling**: Tất cả API đều trả về `ApiResponse` với format thống nhất
4. **Pagination**: Hỗ trợ phân trang với Spring Data
5. **Search**: Tìm kiếm không phân biệt hoa thường

## Mở rộng

Để mở rộng thêm tính năng:
1. Thêm endpoint mới vào `CategoryApiController`
2. Cập nhật DTO nếu cần
3. Thêm JavaScript function tương ứng trong `ajax-list.html`
4. Cập nhật giao diện nếu cần
