package com.example.demo07thymeleaf.repository;

import com.example.demo07thymeleaf.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
