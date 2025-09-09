package vn.iot.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/dashboard")
public class AdminDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String view = req.getParameter("view");
        String viewPage = "/views/home.jsp"; // mặc định

        if ("category_list".equals(view)) {
            viewPage = "/views/category/list.jsp";
        } else if ("category_add".equals(view)) {
            viewPage = "/views/category/add.jsp";
        } else if ("product_list".equals(view)) {
            viewPage = "/views/product/list.jsp";
        } else if ("user_list".equals(view)) {
            viewPage = "/views/user/list.jsp";
        }

        req.setAttribute("viewPage", viewPage);
        req.getRequestDispatcher("/admin/dashboard.jsp").forward(req, resp);
    }
}
