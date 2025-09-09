package vn.iot.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iot.dao.CategoryDAO;
import vn.iot.entity.Category;

@WebServlet(urlPatterns={
  "/admin/category","/admin/category/edit",
  "/admin/category/create","/admin/category/update","/admin/category/delete"
})
public class CategoryServlet extends HttpServlet {
  private final CategoryDAO dao = new CategoryDAO();

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String uri = req.getRequestURI();
    if(uri.endsWith("/edit")){
      int id = Integer.parseInt(req.getParameter("id"));
      req.setAttribute("item", dao.findById(id));
    } else if(uri.endsWith("/delete")){
      int id = Integer.parseInt(req.getParameter("id"));
      dao.remove(id);
      resp.sendRedirect(req.getContextPath()+"/admin/category");
      return;
    }
    List<Category> list = dao.findAll();
    req.setAttribute("items", list);
    req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String uri = req.getRequestURI();

    String name = req.getParameter("name");
    String images = req.getParameter("images");
    int status = Integer.parseInt(req.getParameter("status"));

    if(uri.endsWith("/create")){
      Category c = new Category();
      c.setCategoryname(name); c.setImages(images); c.setStatus(status);
      dao.create(c);
    } else if(uri.endsWith("/update")){
      int id = Integer.parseInt(req.getParameter("id"));
      Category c = new Category();
      c.setCategoryId(id); c.setCategoryname(name); c.setImages(images); c.setStatus(status);
      dao.update(c);
    }
    resp.sendRedirect(req.getContextPath()+"/admin/category");
  }
}
