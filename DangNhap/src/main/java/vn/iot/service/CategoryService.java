package vn.iot.service;

import java.util.List;           // 🔹 import List
import vn.iot.model.Category;   // 🔹 import Category model

public interface CategoryService {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category get(int id);
    List<Category> getAllByUser(int userId);
}
