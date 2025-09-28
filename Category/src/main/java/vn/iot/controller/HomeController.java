package vn.iot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iot.dao.CategoryDAO;
import vn.iot.dao.UserDAO;

import java.io.IOException;

public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CategoryDAO categoryDao = new CategoryDAO();
    private UserDAO userDao = new UserDAO();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        try {
            // Lấy thống kê cho dashboard
            int categoryCount = categoryDao.count();
            int userCount = userDao.findAll().size();
            
            // Set attributes
            req.setAttribute("categoryCount", categoryCount);
            req.setAttribute("userCount", userCount);
            req.setAttribute("videoCount", 0); // Tạm thời set 0, sẽ cập nhật khi có VideoDAO
            
        } catch (Exception e) {
            // Nếu có lỗi, set giá trị mặc định
            req.setAttribute("categoryCount", 0);
            req.setAttribute("userCount", 1);
            req.setAttribute("videoCount", 0);
        }
        
        // Forward to dashboard
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        doGet(req, resp);
    }
    
    @Override
    public void destroy() {
        if (categoryDao != null) {
            categoryDao.close();
        }
        if (userDao != null) {
            userDao.close();
        }
        super.destroy();
    }
}