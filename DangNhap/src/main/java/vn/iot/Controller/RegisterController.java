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

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        User u = new User();
        u.setUsername(username);
        u.setFullName(fullname);
        u.setPassword(password);
        u.setPhone(phone);
        u.setEmail(email);
        u.setRoleid(2); // mặc định role 2 = user
        u.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));

        service.register(u);

        // Redirect về login
        resp.sendRedirect(req.getContextPath() + "/login?success=1");
    }
}

