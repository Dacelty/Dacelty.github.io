package com.example.demo07thymeleaf.controller;

import com.example.demo07thymeleaf.entity.Account;
import com.example.demo07thymeleaf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/home-acc")
    public String trangChu(Model model) {
        List<Account> accounts = accountService.getAll();
        model.addAttribute("listAccount", accounts);
        return "index.html";
    }

    @GetMapping("acc-add")
    public String add(Model model){
        List<Account> accounts = accountService.getAll();
        model.addAttribute("listAccount", accounts);
        return "acc-add.html";
    }

    @PostMapping("/acc/save")
    public String save(@ModelAttribute Account account, Model model){
        accountService.save(account);
        return "redirect:/home";
    }
}
