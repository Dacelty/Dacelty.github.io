package com.example.doan_ecomjpshop.repository;

import com.example.doan_ecomjpshop.entity.SaleOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface SaleOrderDetailsRepository extends JpaRepository<SaleOrderDetails,Integer> {
    List<SaleOrderDetails> findByIdIn(List<Integer> saleOrderDetailsesID);
}
