package com.example.doan_ecomjpshop.controller;

import com.example.doan_ecomjpshop.entity.Category;
import com.example.doan_ecomjpshop.entity.Item;
import com.example.doan_ecomjpshop.request.UpsertCategoryRequest;
import com.example.doan_ecomjpshop.request.UpsertItemRequest;
import com.example.doan_ecomjpshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class ItemController {
    @Autowired
    private ItemService itemService;

    // 1. Lấy danh sách item
    @GetMapping("items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    // 2. Lấy item theo
    @GetMapping("items/{id}")
    public Item getItemByID(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    // 3. Tạo item
    @PostMapping("items")
    public Item createItem(@RequestBody UpsertItemRequest request) {
        return itemService.createItem(request);
    }

    // 4. Cập nhật item
    @PutMapping("items/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody UpsertItemRequest request) {
        return itemService.updateItem(id, request);
    }

    // 5. Xóa item
    @DeleteMapping("items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
    }

}
