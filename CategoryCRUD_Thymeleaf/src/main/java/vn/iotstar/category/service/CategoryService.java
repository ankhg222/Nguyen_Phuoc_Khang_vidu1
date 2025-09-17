package vn.iotstar.category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iotstar.category.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Page<Category> search(String keyword, Pageable pageable);
    Page<Category> list(Pageable pageable);
    Category save(Category category);
    Optional<Category> findById(Long id);
    void deleteById(Long id);
}
