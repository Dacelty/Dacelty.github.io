package com.example.doan_ecomjpshop.service;

import com.example.doan_ecomjpshop.entity.Category;
import com.example.doan_ecomjpshop.exception.BadRequestException;
import com.example.doan_ecomjpshop.exception.NotFoundException;
import com.example.doan_ecomjpshop.repository.CategoryRepository;
import com.example.doan_ecomjpshop.request.UpsertCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });
    }

    public Category createCategory(UpsertCategoryRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new BadRequestException("Name is required");
        }

        if (categoryRepository.findByName(request.getName()).isPresent()) {
            throw new BadRequestException("Category is exist");
        }

        Category category = new Category();
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, UpsertCategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });

        if (request.getName() == null || request.getName().equals("")) {
            throw new BadRequestException("Name is required");
        }

        if (categoryRepository.findByName(request.getName()).isPresent()
                && !categoryRepository.findByName(request.getName()).get().getName().equals(category.getName())) {
            throw new BadRequestException("Category is exist");
        }

        category.setName(request.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + id);
        });

        categoryRepository.delete(category);
    }
}
