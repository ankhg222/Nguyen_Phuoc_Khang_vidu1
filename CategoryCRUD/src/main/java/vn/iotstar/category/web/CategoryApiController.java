package vn.iotstar.category.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.category.dto.ApiResponse;
import vn.iotstar.category.dto.CategoryRequest;
import vn.iotstar.category.dto.CategoryResponse;
import vn.iotstar.category.entity.Category;
import vn.iotstar.category.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Category Management", description = "API quản lý Category")
public class CategoryApiController {

    private final CategoryService categoryService;

    // Lấy danh sách categories với phân trang và tìm kiếm
    @Operation(
            summary = "Lấy danh sách categories",
            description = "Lấy danh sách tất cả categories với phân trang và tìm kiếm"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Lấy danh sách thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @GetMapping
    public ResponseEntity<ApiResponse<Page<CategoryResponse>>> getAllCategories(
            @Parameter(description = "Số trang (bắt đầu từ 0)", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Số lượng items mỗi trang", example = "10")
            @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Từ khóa tìm kiếm theo tên category", example = "Electronics")
            @RequestParam(required = false) String search) {
        
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Category> categories = categoryService.search(search, pageable);
            
            Page<CategoryResponse> categoryResponses = categories.map(CategoryResponse::fromEntity);
            
            return ResponseEntity.ok(ApiResponse.success("Lấy danh sách categories thành công", categoryResponses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi lấy danh sách categories: " + e.getMessage()));
        }
    }

    // Lấy category theo ID
    @Operation(
            summary = "Lấy category theo ID",
            description = "Lấy thông tin chi tiết của một category theo ID"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Lấy category thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Không tìm thấy category",
                    content = @Content
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(
            @Parameter(description = "ID của category", example = "1")
            @PathVariable Long id) {
        try {
            return categoryService.findById(id)
                    .map(category -> ResponseEntity.ok(ApiResponse.success("Lấy category thành công", 
                            CategoryResponse.fromEntity(category))))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(ApiResponse.error("Không tìm thấy category với ID: " + id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi lấy category: " + e.getMessage()));
        }
    }

    // Tạo category mới
    @Operation(
            summary = "Tạo category mới",
            description = "Tạo một category mới với thông tin được cung cấp"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "Tạo category thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(
                                    value = "{\"success\": true, \"message\": \"Tạo category thành công\", \"data\": {\"id\": 1, \"name\": \"Electronics\", \"active\": true}}"
                            )
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Dữ liệu không hợp lệ",
                    content = @Content
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Thông tin category cần tạo",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRequest.class),
                            examples = @ExampleObject(
                                    value = "{\"name\": \"Electronics\", \"image\": \"https://example.com/image.jpg\", \"active\": true}"
                            )
                    )
            )
            @Valid @RequestBody CategoryRequest request,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Dữ liệu không hợp lệ: " + errorMessage));
        }

        try {
            Category category = Category.builder()
                    .categoryName(request.getName())
                    .image(request.getImage())
                    .icon(request.getIcon())
                    .active(request.getActive())
                    .build();

            Category savedCategory = categoryService.save(category);
            CategoryResponse response = CategoryResponse.fromEntity(savedCategory);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.success("Tạo category thành công", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi tạo category: " + e.getMessage()));
        }
    }

    // Cập nhật category
    @Operation(
            summary = "Cập nhật category",
            description = "Cập nhật thông tin của một category theo ID"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Cập nhật category thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Dữ liệu không hợp lệ",
                    content = @Content
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Không tìm thấy category",
                    content = @Content
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(
            @Parameter(description = "ID của category cần cập nhật", example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Thông tin category cần cập nhật",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CategoryRequest.class)
                    )
            )
            @Valid @RequestBody CategoryRequest request,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Dữ liệu không hợp lệ: " + errorMessage));
        }

        try {
            return categoryService.findById(id)
                    .map(existingCategory -> {
                        existingCategory.setCategoryName(request.getName());
                        existingCategory.setImage(request.getImage());
                        existingCategory.setIcon(request.getIcon());
                        existingCategory.setActive(request.getActive());

                        Category updatedCategory = categoryService.save(existingCategory);
                        CategoryResponse response = CategoryResponse.fromEntity(updatedCategory);

                        return ResponseEntity.ok(ApiResponse.success("Cập nhật category thành công", response));
                    })
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(ApiResponse.error("Không tìm thấy category với ID: " + id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi cập nhật category: " + e.getMessage()));
        }
    }

    // Xóa category
    @Operation(
            summary = "Xóa category",
            description = "Xóa một category theo ID"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Xóa category thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Không tìm thấy category",
                    content = @Content
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(
            @Parameter(description = "ID của category cần xóa", example = "1")
            @PathVariable Long id) {
        try {
            if (!categoryService.findById(id).isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Không tìm thấy category với ID: " + id));
            }

            categoryService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Xóa category thành công", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi xóa category: " + e.getMessage()));
        }
    }

    // Lấy tất cả categories (không phân trang) - dùng cho dropdown
    @Operation(
            summary = "Lấy tất cả categories",
            description = "Lấy danh sách tất cả categories không phân trang (dùng cho dropdown)"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Lấy danh sách thành công",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Lỗi server",
                    content = @Content
            )
    })
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategoriesList() {
        try {
            Pageable pageable = PageRequest.of(0, 1000); // Lấy tối đa 1000 records
            Page<Category> categories = categoryService.list(pageable);
            
            List<CategoryResponse> categoryResponses = categories.getContent().stream()
                    .map(CategoryResponse::fromEntity)
                    .collect(Collectors.toList());
            
            return ResponseEntity.ok(ApiResponse.success("Lấy danh sách categories thành công", categoryResponses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Lỗi khi lấy danh sách categories: " + e.getMessage()));
        }
    }
}
