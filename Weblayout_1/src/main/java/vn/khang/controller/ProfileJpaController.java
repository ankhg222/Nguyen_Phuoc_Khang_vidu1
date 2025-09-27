package vn.khang.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import vn.khang.dao.UserJpaDao;
import vn.khang.entity.UserEntity;
import vn.khang.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * ProfileJpaController - Sử dụng JPA để update profile
 * Để demo cả 2 phương pháp: JDBC (ProfileController) và JPA (ProfileJpaController)
 * 
 * @author Nguyễn Phước Khang - 23110236
 */
@WebServlet("/profile-jpa")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 5 * 1024 * 1024,
    maxRequestSize = 10 * 1024 * 1024
)
public class ProfileJpaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserJpaDao userJpaDao;

    @Override
    public void init() {
        try {
            userJpaDao = new UserJpaDao();
            System.out.println("✅ ProfileJpaController initialized successfully!");
        } catch (Exception e) {
            System.err.println("❌ ProfileJpaController init failed: " + e.getMessage());
            // JPA initialization failed, but don't crash the entire servlet
            userJpaDao = null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Check if JPA is available
        if (userJpaDao == null) {
            req.setAttribute("error", "JPA không khả dụng. Vui lòng kiểm tra cấu hình database!");
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }
        
        // Kiểm tra đăng nhập
        User account = (User) req.getSession().getAttribute("account");
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        
        if (account == null && userId == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        
        try {
            // Lấy thông tin user mới nhất từ database bằng JPA
            int id = (account != null) ? account.getId() : userId;
            UserEntity userEntity = userJpaDao.findById(id);
        
        // Convert UserEntity to User for JSP
        User u = convertToUser(userEntity);
        req.setAttribute("user", u);
        req.setAttribute("title", "Profile JPA - " + (u.getFullname() != null ? u.getFullname() : u.getUsername()));
        req.setAttribute("useJpa", true);
        req.getRequestDispatcher("/views/profile-jpa.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Kiểm tra đăng nhập
        User account = (User) req.getSession().getAttribute("account");
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        
        if (account == null && userId == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");
        
        int id = (account != null) ? account.getId() : userId;

        // Validate input
        if (fullName == null || fullName.trim().isEmpty()) {
            req.setAttribute("error", "Họ tên không được để trống!");
            UserEntity userEntity = userJpaDao.findById(id);
            User u = convertToUser(userEntity);
            req.setAttribute("user", u);
            req.setAttribute("useJpa", true);
            req.getRequestDispatcher("/views/profile-jpa.jsp").forward(req, resp);
            return;
        }

        // Xử lý upload ảnh với validation
        Part imagePart = req.getPart("image");
        String imageFileName = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            String submittedFileName = imagePart.getSubmittedFileName();
            if (submittedFileName != null && !submittedFileName.isEmpty()) {
                // Validate file type
                String fileExt = "";
                int dotIndex = submittedFileName.lastIndexOf('.');
                if (dotIndex >= 0) {
                    fileExt = submittedFileName.substring(dotIndex).toLowerCase();
                }
                
                if (!fileExt.matches("\\.(jpg|jpeg|png|gif)")) {
                    req.setAttribute("error", "Chỉ cho phép upload file ảnh (jpg, jpeg, png, gif)!");
                    UserEntity userEntity = userJpaDao.findById(id);
                    User u = convertToUser(userEntity);
                    req.setAttribute("user", u);
                    req.setAttribute("useJpa", true);
                    req.getRequestDispatcher("/views/profile-jpa.jsp").forward(req, resp);
                    return;
                }

                // Tạo thư mục uploads
                String uploadDir = getServletContext().getRealPath("/uploads");
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Tạo tên file unique
                String newFileName = "avatar_jpa_" + id + "_" + System.currentTimeMillis() + fileExt;
                Path filePath = uploadPath.resolve(newFileName);

                // Save file
                try (InputStream inputStream = imagePart.getInputStream()) {
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                    imageFileName = newFileName;
                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "Lỗi khi upload file: " + e.getMessage());
                    UserEntity userEntity = userJpaDao.findById(id);
                    User u = convertToUser(userEntity);
                    req.setAttribute("user", u);
                    req.setAttribute("useJpa", true);
                    req.getRequestDispatcher("/views/profile-jpa.jsp").forward(req, resp);
                    return;
                }
            }
        }

        // Update profile using JPA
        boolean success = userJpaDao.updateProfile(id, fullName.trim(), phone, imageFileName);
        
        if (success) {
            req.setAttribute("success", "Cập nhật thông tin thành công bằng JPA!");
            UserEntity updatedEntity = userJpaDao.findById(id);
            User updatedUser = convertToUser(updatedEntity);
            req.setAttribute("user", updatedUser);
            
            // Cập nhật session nếu cần
            if (account != null) {
                req.getSession().setAttribute("account", updatedUser);
            }
        } else {
            req.setAttribute("error", "Cập nhật thông tin thất bại!");
            UserEntity userEntity = userJpaDao.findById(id);
            User u = convertToUser(userEntity);
            req.setAttribute("user", u);
        }
        
        req.setAttribute("title", "Profile JPA - " + fullName);
        req.setAttribute("useJpa", true);
        req.getRequestDispatcher("/views/profile-jpa.jsp").forward(req, resp);
    }
    
    /**
     * Convert UserEntity to User model
     */
    private User convertToUser(UserEntity entity) {
        if (entity == null) return null;
        
        User user = new User();
        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setUsername(entity.getUsername());
        user.setFullname(entity.getFullname());
        user.setPassword(entity.getPassword());
        user.setAvatar(entity.getAvatar());
        user.setRoleId(entity.getRoleid());
        user.setPhone(entity.getPhone());
        // Note: createdDate conversion might need adjustment based on your User model
        
        return user;
    }
}