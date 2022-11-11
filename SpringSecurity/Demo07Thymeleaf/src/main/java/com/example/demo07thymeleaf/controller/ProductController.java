package com.example.demo07thymeleaf.controller;

import com.example.demo07thymeleaf.entity.Product;
import com.example.demo07thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String trangChu(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("listProduct", products);
        return "index-acc.html";
    }

    @GetMapping("product-add")
    public String add(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("listProduct", products);
        return "product-add.html";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, Model model){
        productService.save(product);
        return "redirect:/home";
    }


}
