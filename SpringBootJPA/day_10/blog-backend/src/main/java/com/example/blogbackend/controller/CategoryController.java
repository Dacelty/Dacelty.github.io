package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.request.UpsertBlogRequest;
import com.example.blogbackend.request.UpsertCategoryRequest;
import com.example.blogbackend.service.BlogService;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // 1. Lấy danh sách category
    @GetMapping("categories")
    public List<Category> getBlogs() {
        return categoryService.getCategories();
    }

    // 2. Lấy chi tiết category
    @GetMapping("categories/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // 3. Tạo category
    @PostMapping("categories")
    public Category createCategory(@RequestBody UpsertCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    // 4. Cập nhật category
    @PutMapping("categories/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody UpsertCategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }

    // 5. Xóa category
    @DeleteMapping("blogs/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
