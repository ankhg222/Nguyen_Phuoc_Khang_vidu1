package vn.iotstar.category.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.category.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    // Tìm kiếm theo tên có phân trang
    Page<Category> findByCategoryNameContainingIgnoreCase(String name, Pageable pageable);
    
    // Tìm kiếm theo tên không phân trang
    List<Category> findByCategoryNameContaining(String name);
    
    // Tìm kiếm theo tên chính xác
    Optional<Category> findByCategoryName(String name);
}