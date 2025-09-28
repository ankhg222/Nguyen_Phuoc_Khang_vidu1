package vn.iotstar.category.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iotstar.category.entity.Category;
import vn.iotstar.category.repo.CategoryRepo;
import vn.iotstar.category.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repo;

    @Override
    public Page<Category> search(String keyword, Pageable pageable) {
        if (keyword == null || keyword.isBlank()) {
            return repo.findAll(pageable);
        }
        return repo.findByCategoryNameContainingIgnoreCase(keyword.trim(), pageable);
    }

    @Override
    public Page<Category> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        return repo.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Category> findByNameContaining(String name) {
        return repo.findByCategoryNameContaining(name);
    }

    @Override
    public Optional<Category> findByCategoryName(String name) {
        return repo.findByCategoryName(name);
    }
}
