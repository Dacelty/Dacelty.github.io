package com.example.demo07thymeleaf.service;

import com.example.demo07thymeleaf.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    List<Product> save(Product product);

}
