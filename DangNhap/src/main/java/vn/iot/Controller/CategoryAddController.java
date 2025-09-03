package vn.iot.Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iot.model.Category;
import vn.iot.model.User;
import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

import vn.iot.model.Category;
import vn.iot.service.CategoryService;

@WebServlet("/category/add")
public class CategoryAddController extends HttpServlet {
  private final CategoryService service = new CategoryServiceImpl();

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    User u = (User) req.getSession().getAttribute("account");
    Category c = new Category();
    c.setName(req.getParameter("name"));
    c.setIcon(req.getParameter("icon"));   // nếu chỉ lưu text
    c.setUserId(u.getId());                // gán theo user đăng nhập
    service.insert(c);
    resp.sendRedirect(req.getContextPath()+"/category/list");
  }
}