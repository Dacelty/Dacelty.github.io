package com.example.springTHCRUD;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepo {

    private ConcurrentHashMap<String, Customer> cust;

    public ConcurrentHashMap<String, Customer> Repo(){
        try {
            File file = ResourceUtils.getFile("src/main/resources/MOCK_DATA.json");
            ObjectMapper mapper = new ObjectMapper();
            Gson gson = new Gson();
            Type type = new TypeToken<ConcurrentHashMap<String, Customer>>(){}.getType();

            cust = gson.fromJson("src/main/resources/MOCK_DATA.json", type);

//            per.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {}));
//
//            for (Person p:per){
//                System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
//            }
//            System.out.println("Đọc dữ liệu từ file thành công.");
//            return per;
            return cust;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConcurrentHashMap<String, Customer> printCustomer(){
        System.out.println("----------------------------------------");
        System.out.println(cust);
        return cust;
    }
}
