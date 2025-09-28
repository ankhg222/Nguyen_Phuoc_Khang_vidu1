package vn.iotstar.category.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.iotstar.category.entity.Category;
import vn.iotstar.category.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    // Danh sách + tìm kiếm + phân trang
    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       @RequestParam(required = false) String q,
                       Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> data = service.search(q, pageable);

        model.addAttribute("data", data);
        model.addAttribute("q", q);
        return "category/list";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }

    // Lưu (tạo mới hoặc cập nhật)
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("category") Category c,
                       BindingResult result,
                       RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "category/form";
        }
        boolean isNew = (c.getCategoryId() == null);
        service.save(c);
        ra.addFlashAttribute("msg",
                isNew ? "Thêm mới Category thành công!" : "Cập nhật Category thành công!");
        return "redirect:/admin/categories";
    }

    // Hiển thị form sửa
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id,
                       Model model,
                       RedirectAttributes ra) {
        return service.findById(id)
                .map(c -> {
                    model.addAttribute("category", c);
                    return "category/form";
                })
                .orElseGet(() -> {
                    ra.addFlashAttribute("msg", "Không tìm thấy Category ID=" + id);
                    return "redirect:/admin/categories";
                });
    }

    // Xóa Category
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes ra) {
        try {
            service.deleteById(id);
            ra.addFlashAttribute("msg", "Xóa Category thành công!");
        } catch (Exception e) {
            ra.addFlashAttribute("msg", "Không thể xóa Category ID=" + id + " (có dữ liệu liên quan)");
        }
        return "redirect:/admin/categories";
    }
}
