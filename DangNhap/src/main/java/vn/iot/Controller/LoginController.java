package vn.iot.Controller;


import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iot.model.User;
import vn.iot.service.UserService;
import vn.iot.service.impl.UserServiceImpl;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    HttpSession session = req.getSession(false);
	    if (session != null && session.getAttribute("account") != null) {
	        resp.sendRedirect(req.getContextPath() + "/waiting");
	        return;
	    }

	    // Đọc cookie "username"
	    String savedUser = null;
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null) {
	        for (Cookie c : cookies) {
	            if ("username".equals(c.getName())) {
	                savedUser = c.getValue();
	            }
	        }
	    }
	    req.setAttribute("savedUser", savedUser);

	    req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRemember = "on".equals(remember);

        if (username.isEmpty() || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu trống");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if (isRemember) {
                Cookie ck = new Cookie("username", username);
                ck.setMaxAge(30 * 60);
                resp.addCookie(ck);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            req.setAttribute("alert", "Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
