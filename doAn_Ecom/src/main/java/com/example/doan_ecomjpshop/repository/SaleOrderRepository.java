package com.example.doan_ecomjpshop.repository;

import com.example.doan_ecomjpshop.entity.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleOrderRepository extends JpaRepository<SaleOrder,Integer> {
}
