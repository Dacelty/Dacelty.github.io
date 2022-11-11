package com.example.demo07thymeleaf.service;


import com.example.demo07thymeleaf.entity.Account;
import com.example.demo07thymeleaf.entity.Product;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {

    List<Account> getAll();

    List<Account> save(Account account);
}
