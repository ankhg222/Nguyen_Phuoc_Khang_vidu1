package vn.iot.service.impl;

import java.util.List;
import vn.iot.dao.ProductDao;
import vn.iot.dao.impl.ProductDaoImpl;
import vn.iot.model.Product;
import vn.iot.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
