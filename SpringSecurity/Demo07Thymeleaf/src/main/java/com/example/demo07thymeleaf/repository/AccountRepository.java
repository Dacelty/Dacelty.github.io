package com.example.demo07thymeleaf.repository;

import com.example.demo07thymeleaf.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
