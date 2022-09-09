package com.example.springWeb;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Repo {
    private ArrayList<Car> car = new ArrayList<>();




    public ArrayList<Car> Repo(){
        try {
            File file = ResourceUtils.getFile("src/main/resources/MOCK_DATA.json");
            ObjectMapper mapper = new ObjectMapper();
            car.addAll(mapper.readValue(file, new TypeReference<List<Car>>() {}));
//            car.forEach(System.out::println);
//            for (Car c:car){
//                System.out.println(c.getBrand() + " - " + c.getModel());
//            }
            System.out.println("Đọc dữ liệu từ file thành công.");
            return car;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllCar(){
        for (Car c:car){
            System.out.println(c.getBrand() + " - " + c.getModel());
        }
    }
}
