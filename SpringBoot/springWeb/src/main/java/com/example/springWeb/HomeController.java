package com.example.springWeb;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal getJSON(){
        return new Animal("mammal","dog");
    }

    @GetMapping(value = "/jsonArray", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Animal> getJSONarray(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("mammal","dog"));
        animals.add(new Animal("mammal","cat"));
        return animals;
    }



}
