package vn.iot.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iot.model.Category;
import vn.iot.model.User;
import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

@WebServlet("/category/list")
public class CategoryListController extends HttpServlet {
    private final CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Lấy user đã login từ session
        User user = (User) req.getSession().getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        List<Category> list = service.getAllByUser(user.getId());
        req.setAttribute("cateList", list);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }
}
