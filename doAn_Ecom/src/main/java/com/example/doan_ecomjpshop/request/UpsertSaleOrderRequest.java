package com.example.doan_ecomjpshop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertSaleOrderRequest {
    private String name;

    private String phone;

    private String email;

    private Integer totalPrice;

    private boolean status;

    private List<Integer> saleOrderDetailsesID;
}
