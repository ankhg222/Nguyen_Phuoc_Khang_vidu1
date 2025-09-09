package vn.iot.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iot.model.Category;
import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/list")
public class CategoryListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy tất cả category
        List<Category> cateList = service.getAll();

        // Gắn vào request scope
        req.setAttribute("cateList", cateList);

        // Forward sang view
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }
}
