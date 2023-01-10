package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.request.UpsertBlogRequest;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // 1. Lấy danh sách blog
    @GetMapping("blogs")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    // 2. Lấy chi tiết blog
    @GetMapping("blogs/{id}")
    public Blog getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }

    // 3. Tạo blog
    @PostMapping("blogs")
    public Blog createBlog(@RequestBody UpsertBlogRequest request) {
        return blogService.createBlog(request);
    }

    // 4. Cập nhật blog
    @PutMapping("blogs/{id}")
    public Blog createBlog(@PathVariable Integer id, @RequestBody UpsertBlogRequest request) {
        return blogService.updateBlog(id, request);
    }

    // 5. Xóa blog
    @DeleteMapping("blogs/{id}")
    public void deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
    }
}
