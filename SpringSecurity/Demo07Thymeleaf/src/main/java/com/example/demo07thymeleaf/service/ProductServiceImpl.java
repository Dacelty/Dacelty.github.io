package com.example.demo07thymeleaf.service;

import com.example.demo07thymeleaf.entity.Product;
import com.example.demo07thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> save(Product product) {
        productRepository.save(product);
        return null;
    }
}
