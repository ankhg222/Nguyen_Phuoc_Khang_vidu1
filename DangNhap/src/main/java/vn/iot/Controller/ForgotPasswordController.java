package vn.iot.Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iot.model.User;
import vn.iot.service.UserService;
import vn.iot.service.impl.UserServiceImpl;

@WebServlet("/forgot_password")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgot_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String newPassword = req.getParameter("newPassword");

        UserService service = new UserServiceImpl();
        User user = service.findByUsername(username);

        if (user != null) {
            boolean updated = service.updatePassword(username, newPassword);
            if (updated) {
                req.setAttribute("message", "Đổi mật khẩu thành công. Mời đăng nhập lại.");
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                return;
            }
        }

        req.setAttribute("error", "Tài khoản không tồn tại hoặc lỗi đổi mật khẩu.");
        req.getRequestDispatcher("/views/forgot_password.jsp").forward(req, resp);
    }
}
