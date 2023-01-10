package com.example.doan_ecomjpshop.controller;

import com.example.doan_ecomjpshop.entity.Category;
import com.example.doan_ecomjpshop.request.UpsertCategoryRequest;
import com.example.doan_ecomjpshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 1. Lấy danh sách cate
    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    // 2. Lấy cate theo ID
    @GetMapping("categories/{id}")
    public Category getCategoryByID(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // 3. Tạo cate
    @PostMapping("categories")
    public Category createCategory(@RequestBody UpsertCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    // 4. Cập nhật cate
    @PutMapping("categories/{id}")
    public Category createBlog(@PathVariable Integer id, @RequestBody UpsertCategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }

    // 5. Xóa cate
    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
