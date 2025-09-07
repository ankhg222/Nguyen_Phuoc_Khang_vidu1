package vn.iot.service.impl;

import java.util.List;
import vn.iot.dao.CategoryDao;
import vn.iot.dao.impl.CategoryDaoImpl;
import vn.iot.model.Category;
import vn.iot.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        dao.insert(category);
    }

    @Override
    public void update(Category category) {
        dao.update(category);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Category get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Category> getAllByUser(int userId) {
        return dao.getAllByUser(userId);
    }

    @Override
    public List<Category> getAll() {
        return dao.getAll();
    }
}
