package com.example.doan_ecomjpshop.controller;

import com.example.doan_ecomjpshop.entity.SaleOrderDetails;
import com.example.doan_ecomjpshop.request.UpsertSaleOrderDetailsRequest;
import com.example.doan_ecomjpshop.service.SaleOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class SaleOrderDetailsController {
    @Autowired
    private SaleOrderDetailsService saleOrderDetailsService;

    // 1. Lấy danh sách sale order
    @GetMapping("saleorderdets")
    public List<SaleOrderDetails> getItems() {
        return saleOrderDetailsService.getSaleOrderDets();
    }

    // 2. Lấy sale order theo id
    @GetMapping("saleorderdets/{id}")
    public SaleOrderDetails getSaleOrderDetByID(@PathVariable Integer id) {
        return saleOrderDetailsService.getSaleOrderDetById(id);
    }

    // 3. Tạo sale order
    @PostMapping("saleorderdets")
    public SaleOrderDetails createSaleOrder(@RequestBody UpsertSaleOrderDetailsRequest request) {
        return saleOrderDetailsService.createSaleOrderDet(request);
    }

    // 4. Cập nhật sale order
    @PutMapping("saleorderdets/{id}")
    public SaleOrderDetails createSaleOrder(@PathVariable Integer id, @RequestBody UpsertSaleOrderDetailsRequest request) {
        return saleOrderDetailsService.updateSaleOrderDet(id, request);
    }

    // 5. Xóa sale order
    @DeleteMapping("saleorderdets/{id}")
    public void deleteSaleOrderDetails(@PathVariable Integer id) {
        saleOrderDetailsService.deleteSaleOrderDet(id);
    }
}
