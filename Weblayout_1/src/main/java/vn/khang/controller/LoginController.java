package vn.khang.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.khang.dao.UserDao;
import vn.khang.model.User;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Nếu đã login thì redirect luôn
        if (req.getSession().getAttribute("userId") != null) {
            resp.sendRedirect(req.getContextPath() + "/profile");
            return;
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = userDao.login(username, password);

        if (u != null) {
            // Lưu session
            req.getSession().setAttribute("userId", u.getId());
            req.getSession().setAttribute("roleId", u.getRoleId());
            req.getSession().setAttribute("fullname", u.getFullname());

            // Phân quyền
            if (u.getRoleId() == 1) { // ADMIN
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
            } else {
                resp.sendRedirect(req.getContextPath() + "/profile");
            }
        } else {
            req.setAttribute("err", "Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
