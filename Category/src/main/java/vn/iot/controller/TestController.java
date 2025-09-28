package vn.iot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TestController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Test Page</title></head>");
        out.println("<body>");
        out.println("<h1>✅ Servlet hoạt động bình thường!</h1>");
        out.println("<p>Context Path: " + req.getContextPath() + "</p>");
        out.println("<p>Request URI: " + req.getRequestURI() + "</p>");
        out.println("<p>Servlet Path: " + req.getServletPath() + "</p>");
        out.println("<hr>");
        out.println("<h3>Các link test:</h3>");
        out.println("<ul>");
        out.println("<li><a href='" + req.getContextPath() + "/'>Trang chủ (/)</a></li>");
        out.println("<li><a href='" + req.getContextPath() + "/home'>Home (/home)</a></li>");
        out.println("<li><a href='" + req.getContextPath() + "/admin'>Admin (/admin)</a></li>");
        out.println("<li><a href='" + req.getContextPath() + "/admin/category'>Category (/admin/category)</a></li>");
        out.println("<li><a href='" + req.getContextPath() + "/admin/profile'>Profile (/admin/profile)</a></li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}