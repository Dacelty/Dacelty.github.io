package com.example.ssdemo.service;

import com.example.ssdemo.entity.Account;
import com.example.ssdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username");
        System.out.println(username);
        Account account = accountRepository.findByUsername(username);
        System.out.println(account);

        if (account == null) {
            throw new EntityNotFoundException("Username or password not found");
        }

        String password = account.getPassword();

        return new User(username, password, Collections.emptyList());
    }
}
