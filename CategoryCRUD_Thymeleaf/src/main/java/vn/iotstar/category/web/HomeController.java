package vn.iotstar.category.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Có thể chuyển hướng thẳng đến danh sách Category
        return "redirect:/admin/categories";
    }
}
