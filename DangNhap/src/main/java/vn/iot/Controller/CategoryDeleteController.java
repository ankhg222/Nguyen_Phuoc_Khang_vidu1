package vn.iot.Controller;
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iot.service.CategoryService;
import vn.iot.service.impl.CategoryServiceImpl;

@WebServlet("/category/delete")
public class CategoryDeleteController extends HttpServlet {
  private final CategoryService service = new CategoryServiceImpl();
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    service.delete(id);
    resp.sendRedirect(req.getContextPath()+"/category/list");
  }
}
