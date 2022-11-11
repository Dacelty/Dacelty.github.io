package com.example.demo07thymeleaf.service;

import com.example.demo07thymeleaf.entity.Account;
import com.example.demo07thymeleaf.entity.Product;
import com.example.demo07thymeleaf.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> save(Account account) {
        account.setPassword(BCrypt.hashpw(account.getPassword(),BCrypt.gensalt(12)));
        accountRepository.save(account);
        return null;
    }

}
