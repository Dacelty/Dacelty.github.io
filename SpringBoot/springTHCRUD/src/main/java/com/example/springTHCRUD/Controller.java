package com.example.springTHCRUD;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cust")
public class Controller {
    private CustomerMapper customerMapper;
    private ConcurrentHashMap<String, Customer> cust;
    @Autowired
    private CustomerRepo repo;

    @GetMapping()
    public ConcurrentHashMap<String, Customer> getJsonCust(){
        return repo.Repo();
    }

    @GetMapping("/print")
    @ResponseBody
    public Map<String, Customer> printCust(){
        return repo.printCustomer();
    }
}

