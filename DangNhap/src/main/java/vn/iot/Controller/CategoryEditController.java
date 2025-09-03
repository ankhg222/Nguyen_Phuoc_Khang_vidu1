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
        Category c = new Category();
        c.setId(Integer.parseInt(req.getParameter("id")));
        c.setName(req.getParameter("name"));
        c.setIcon(req.getParameter("icon"));
        service.update(c);
        resp.sendRedirect(req.getContextPath() + "/category/list");
    }
}
