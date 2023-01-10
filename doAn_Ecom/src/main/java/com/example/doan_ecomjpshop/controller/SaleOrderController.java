package com.example.doan_ecomjpshop.controller;

import com.example.doan_ecomjpshop.entity.Item;
import com.example.doan_ecomjpshop.entity.SaleOrder;
import com.example.doan_ecomjpshop.repository.SaleOrderRepository;
import com.example.doan_ecomjpshop.request.UpsertItemRequest;
import com.example.doan_ecomjpshop.request.UpsertSaleOrderRequest;
import com.example.doan_ecomjpshop.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class SaleOrderController {
    @Autowired
    private SaleOrderService saleOrderService;

    // 1. Lấy danh sách sale order
    @GetMapping("saleorders")
    public List<SaleOrder> getItems() {
        return saleOrderService.getSaleOrders();
    }

    // 2. Lấy sale order theo id
    @GetMapping("saleorders/{id}")
    public SaleOrder getSaleOrderByID(@PathVariable Integer id) {
        return saleOrderService.getSaleOrderById(id);
    }

    // 3. Tạo sale order
    @PostMapping("saleorders")
    public SaleOrder createSaleOrder(@RequestBody UpsertSaleOrderRequest request) {
        return saleOrderService.createSaleOrder(request);
    }

    // 4. Cập nhật sale order
    @PutMapping("saleorders/{id}")
    public SaleOrder createSaleOrder(@PathVariable Integer id, @RequestBody UpsertSaleOrderRequest request) {
        return saleOrderService.updateSaleOrder(id, request);
    }

    // 5. Xóa sale order
    @DeleteMapping("saleorders/{id}")
    public void deleteItem(@PathVariable Integer id) {
        saleOrderService.deleteSaleOrder(id);
    }
}
