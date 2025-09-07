package vn.iot.dao;

import java.util.List;
import vn.iot.model.Category;


public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int id);

    Category get(int id);
    List<Category> getAllByUser(int userId);
    List<Category> getAll();
}
