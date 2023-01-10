package com.example.doan_ecomjpshop.repository;

import com.example.doan_ecomjpshop.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    Optional<Manager> findByEmail(String email);
}
