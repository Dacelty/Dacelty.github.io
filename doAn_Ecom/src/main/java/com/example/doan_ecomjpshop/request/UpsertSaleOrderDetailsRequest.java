package com.example.doan_ecomjpshop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertSaleOrderDetailsRequest {
    private Integer sales_quantity;

    private Integer total_price_by_product;

    private Integer saleOrder;

    private Integer item;
}
