package vn.khang.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/dashboard")
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Kiểm tra quyền trong session
        Integer roleId = (Integer) req.getSession().getAttribute("roleId");
        if (roleId == null || roleId != 1) { // chỉ ADMIN mới vào
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Bạn không có quyền truy cập");
            return;
        }

        req.getRequestDispatcher("/views/admin/dashboard.jsp").forward(req, resp);
    }
}
