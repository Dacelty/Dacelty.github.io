package com.example.springCRUDNangCao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String name;
    private String category;
    @NotNull
    private String detail;
    @NotNull(message = "Cần có photo cho product.")
    private MultipartFile photo;
}
