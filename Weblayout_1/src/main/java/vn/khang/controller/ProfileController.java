package vn.khang.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import vn.khang.dao.UserDao;
import vn.khang.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet("/profile")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 5 * 1024 * 1024,
    maxRequestSize = 10 * 1024 * 1024
)
public class ProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/views/login");
            return;
        }
        User u = userDao.findById(userId);
        req.setAttribute("user", u);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/views/login");
            return;
        }

        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");

        // Xử lý upload ảnh
        Part imagePart = req.getPart("image");
        String imagePathForDb = null;

        if (imagePart != null && imagePart.getSize() > 0) {
            String submitted = Paths.get(imagePart.getSubmittedFileName())
                                    .getFileName().toString();
            String ext = "";
            int dot = submitted.lastIndexOf('.');
            if (dot >= 0) ext = submitted.substring(dot).toLowerCase();

            String uploadDir = getServletContext().getRealPath("/uploads");
            Files.createDirectories(Paths.get(uploadDir));

            String newName = UUID.randomUUID().toString().replace("-", "") + ext;
            Path dest = Paths.get(uploadDir, newName);
            try (InputStream in = imagePart.getInputStream()) {
                Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
            }
            imagePathForDb = "uploads/" + newName;
        }

        boolean ok = userDao.updateProfile(userId, fullName, phone, imagePathForDb);
        if (ok) req.setAttribute("msg", "Cập nhật thành công");
        else    req.setAttribute("err", "Cập nhật thất bại");

        User u = userDao.findById(userId);
        req.setAttribute("user", u);
        req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
    }
}
