package com.tn.controller;

import com.tn.entity.Account;
import com.tn.repository.AccountRepository;
import com.tn.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @GetMapping("account/search")
    public List<Account> search(@RequestParam(required = false) String username,
                                @RequestParam(required = false) Integer minId,
                                @RequestParam(required = false) String email) {

        Specification<Account> specification = AccountSpecification.buildWhere(username, minId, email);
        List<Account> accounts = accountRepo.findAll(specification);

        return accounts;
    }

}
