package vn.iot.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import vn.iot.model.Category;
import vn.iot.model.User;
import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
@MultipartConfig   // cần để xử lý upload file
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // Lấy user đăng nhập từ session (nếu có)
        User u = (User) req.getSession().getAttribute("account");

        // Lấy dữ liệu từ form
        String name = req.getParameter("name");
        Part filePart = req.getPart("icon"); // input type="file" name="icon"

        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            // Đường dẫn thư mục lưu ảnh (webapp/uploads)
            String uploadDir = getServletContext().getRealPath("/uploads");
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs(); // tạo thư mục nếu chưa có
            }
            String uploadPath = uploadDir + File.separator + fileName;
            filePart.write(uploadPath);
        }

        Category c = new Category();
        c.setCateName(name);
        c.setIcon(fileName);   // icon = tên file ảnh
        if (u != null) {
            c.setUserId(u.getId());
        }


        // Lưu DB
        service.insert(c);

        // Quay lại trang danh sách
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
