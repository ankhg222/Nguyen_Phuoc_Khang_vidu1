package vn.iot.dao;

import java.util.List;
import vn.iot.model.Product;

public interface ProductDao {
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    Product get(int id);
    List<Product> getAll();
}
