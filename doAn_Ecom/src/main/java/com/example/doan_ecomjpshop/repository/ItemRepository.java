package com.example.doan_ecomjpshop.repository;

import com.example.doan_ecomjpshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
