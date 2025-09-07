package vn.iot.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iot.model.Category;
import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

@WebServlet("/category/edit")
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("cate", service.get(id));
        req.getRequestDispatcher("/views/category/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String icon = req.getParameter("icon");

        // Tạo Category object
        Category c = new Category();
        c.setCateId(id);
        c.setCateName(name);
        c.setIcon(icon);

        // Update DB
        service.update(c);

        // Redirect về danh sách
        resp.sendRedirect(req.getContextPath() + "/category/list");
    }
}
