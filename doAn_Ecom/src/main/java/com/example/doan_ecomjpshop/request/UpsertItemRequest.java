package com.example.doan_ecomjpshop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertItemRequest {
    private String name;

    private String thumbnail;

    private String description;

    private Integer quantity;

    private Integer price;

    private Integer category;
}
