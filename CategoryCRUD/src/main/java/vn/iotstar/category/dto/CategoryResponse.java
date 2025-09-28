package vn.iotstar.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.iotstar.category.entity.Category;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    
    private Long id;
    private String name;
    private String image;
    private Boolean active;
    private LocalDateTime createdAt;
    
    public static CategoryResponse fromEntity(Category category) {
        return CategoryResponse.builder()
                .id(category.getCategoryId())
                .name(category.getCategoryName())
                .image(category.getImage())
                .active(category.getActive())
                .createdAt(category.getCreatedAt())
                .build();
    }
}
