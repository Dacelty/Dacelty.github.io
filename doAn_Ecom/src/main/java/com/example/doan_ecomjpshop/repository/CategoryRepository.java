package com.example.doan_ecomjpshop.repository;

import com.example.doan_ecomjpshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    Optional<Category> findByName(String name);
}
