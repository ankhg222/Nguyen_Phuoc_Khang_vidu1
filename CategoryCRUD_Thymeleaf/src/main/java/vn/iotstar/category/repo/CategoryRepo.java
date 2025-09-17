package vn.iotstar.category.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.category.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    // Tìm kiếm theo tên có phân trang
    Page<Category> findByNameContainingIgnoreCase(String name, Pageable pageable);
}