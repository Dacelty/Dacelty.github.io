package com.example.doan_ecomjpshop.service;

import com.example.doan_ecomjpshop.entity.Category;
import com.example.doan_ecomjpshop.entity.Item;
import com.example.doan_ecomjpshop.exception.NotFoundException;
import com.example.doan_ecomjpshop.repository.CategoryRepository;
import com.example.doan_ecomjpshop.repository.ItemRepository;
import com.example.doan_ecomjpshop.request.UpsertItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // 1. Lấy danh sách item
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Integer id) {
        return itemRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
    }

    public Item createItem(UpsertItemRequest request) {
        Category category = categoryRepository.findById(request.getCategory()).orElseThrow(() -> {
            throw new NotFoundException("Not found category with id = " + request.getCategory());
        });

        Item item = Item.builder()
                .name(request.getName())
                .thumbnail(request.getThumbnail())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .category(category)
                .build();

        return itemRepository.save(item);
    }

    public Item updateItem(Integer id, UpsertItemRequest request) {
        Item item = itemRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
        Category category = categoryRepository.findById(request.getCategory()).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + request.getCategory());
        });

        item.setName(request.getName());
        item.setThumbnail(request.getThumbnail());
        item.setDescription(request.getDescription());
        item.setQuantity(request.getQuantity());
        item.setPrice(request.getPrice());
        item.setCategory(category);

        return itemRepository.save(item);
    }

    public void deleteItem(Integer id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found with id = " + id);
        });
        itemRepository.delete(item);
    }
}
