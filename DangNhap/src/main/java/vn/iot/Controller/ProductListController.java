package vn.iot.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iot.model.Product;
import vn.iot.service.ProductService;
import vn.iot.service.impl.ProductServiceImpl;

@WebServlet("/product/list")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService service = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> productList = service.getAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
    }
}
