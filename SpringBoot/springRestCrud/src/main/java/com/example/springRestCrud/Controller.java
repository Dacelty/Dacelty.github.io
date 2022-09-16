package com.example.springRestCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private EmpRepo repo;

    @GetMapping()
    public ArrayList<Employee> getEmp(){
        return repo.Repo();
    }


    @GetMapping(value = "/DTO", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<EmployeeDTO> getJsonPpl(){
        return repo.RepoDTO();
    }
}
