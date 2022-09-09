package com.example.springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private Repo repo;



    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal getJSON(){
        return new Animal("mammal","dog");
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal getMAP(){
        return new Animal("mammal","dog");
    }

    @GetMapping(value = "/jsonArray", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animal> getJSONarray(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("mammal","dog"));
        animals.add(new Animal("mammal","cat"));
        return animals;
    }

    @GetMapping(value = "/jsonCar")
    public ArrayList<Car> getJSONCar(){
        return repo.Repo();
    }

    @GetMapping(value = "/jsonCarAll")
    public void getAllCars(){
        repo.getAllCar();
    }





}
