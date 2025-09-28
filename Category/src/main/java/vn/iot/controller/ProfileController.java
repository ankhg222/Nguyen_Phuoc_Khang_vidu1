package vn.iot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iot.dao.UserDAO;
import vn.iot.entity.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 10,  // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDao = new UserDAO();
    
    // Thư mục lưu trữ file upload
    private static final String UPLOAD_DIR = "uploads";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String url = req.getRequestURI();
        
        if (url.contains("/admin/profile")) {
            showProfile(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String url = req.getRequestURI();
        
        if (url.contains("/admin/profile/update")) {
            updateProfile(req, resp);
        }
    }
    
    private void showProfile(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        // Lấy user từ session (giả sử đã đăng nhập)
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        
        if (userId == null) {
            // Nếu chưa đăng nhập, tạo user mẫu để test
            userId = 1;
            session.setAttribute("userId", userId);
        }
        
        User user = userDao.findById(userId);
        if (user == null) {
            // Tạo user mẫu nếu không tìm thấy
            user = new User();
            user.setId(1);
            user.setUsername("admin");
            user.setEmail("admin@example.com");
            user.setFullname("Administrator");
            user.setPhone("0123456789");
            user.setImages("default-avatar.jpg");
        }
        
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/admin/profile.jsp").forward(req, resp);
    }
    
    private void updateProfile(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        try {
            // Lấy user từ session
            HttpSession session = req.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            
            if (userId == null) {
                userId = 1; // Test user
            }
            
            // Lấy thông tin từ form
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");
            
            // Xử lý upload file
            String imageFileName = null;
            Part imagePart = req.getPart("imageFile");
            
            if (imagePart != null && imagePart.getSize() > 0) {
                imageFileName = uploadImage(imagePart, req);
            }
            
            // Cập nhật profile
            boolean success = userDao.updateProfile(userId, fullname, phone, imageFileName);
            
            if (success) {
                req.setAttribute("message", "Cập nhật profile thành công!");
                req.setAttribute("alertType", "success");
            } else {
                req.setAttribute("message", "Có lỗi xảy ra khi cập nhật profile!");
                req.setAttribute("alertType", "danger");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Có lỗi xảy ra: " + e.getMessage());
            req.setAttribute("alertType", "danger");
        }
        
        // Chuyển về trang profile
        showProfile(req, resp);
    }
    
    private String uploadImage(Part imagePart, HttpServletRequest req) throws IOException {
        // Lấy tên file gốc
        String originalFileName = imagePart.getSubmittedFileName();
        
        if (originalFileName == null || originalFileName.trim().isEmpty()) {
            return null;
        }
        
        // Tạo tên file mới để tránh trùng lặp
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileName = System.currentTimeMillis() + fileExtension;
        
        // Đường dẫn thư mục upload
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        
        // Tạo thư mục nếu chưa tồn tại
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        // Đường dẫn file đầy đủ
        Path filePath = Paths.get(uploadPath, newFileName);
        
        // Lưu file
        Files.copy(imagePart.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        
        return newFileName;
    }
    
    @Override
    public void destroy() {
        if (userDao != null) {
            userDao.close();
        }
        super.destroy();
    }
}