package com.example.ktRESTAPI.repository;

import com.example.ktRESTAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

