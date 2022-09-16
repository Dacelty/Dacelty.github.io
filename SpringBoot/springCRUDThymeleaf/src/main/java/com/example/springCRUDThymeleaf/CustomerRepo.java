package com.example.springCRUDThymeleaf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepo {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepo() {
        List<Customer> list;
        try {
            list = new ArrayList<>();
            File file = ResourceUtils.getFile("src/main/resources/MOCK_DATA.json");
            ObjectMapper mapper = new ObjectMapper();
            list.addAll(mapper.readValue(file, new TypeReference<List<Customer>>() {
            }));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        customers.addAll(list);
    }

    public List<Customer> getAll(){
        return this.customers;
    }

    public Customer create(Customer c){
        int id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            Customer lastC = customers.get(customers.size() - 1);
            id = lastC.getId() + 1;
        }
        c.setId(id);
        customers.add(c);
        return c;
    }

    public Customer edit(Customer c){
        get(c.getId()).ifPresent(existPerson->{
            existPerson.setFullname(c.getFullname());
            existPerson.setEmail(c.getEmail());
            existPerson.setPhone(c.getPhone());
        });
        return c;
    }

    public void delete(Customer c){
        deleteById(c.getId());
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> customers.remove(existed));
    }

    public Optional<Customer> get(int id) {
        return customers.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Customer search(String name){
        return customers.stream().filter(cust->cust.getFullname().contains(name)).findAny().orElse(null);
    }

    public Customer searchEmail(String email){
        return customers.stream().filter(cust->cust.getFullname().contains(email)).findAny().orElse(null);
    }
}
