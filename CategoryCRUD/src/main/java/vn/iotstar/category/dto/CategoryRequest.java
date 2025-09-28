package vn.iotstar.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    
    @NotBlank(message = "Tên danh mục không được để trống")
    private String name;
    
    private String image;
    
    private String icon;
    
    private Boolean active = true;
}
