package com.tn.controller;

import com.tn.entity.Employee;
import com.tn.repository.EmployeeRepository;
import com.tn.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("employee")
    public String search(Model model,
                         @RequestParam(required = false) String hoTen,
                         @RequestParam(required = false) String email) {

        Specification<Employee> specification = EmployeeSpecification.buildWhere(hoTen, email);
        System.out.println(specification);
        List<Employee> employees = employeeRepo.findAll(specification);
        System.out.println(employees);

        model.addAttribute("listEmployee", employees);

        return "employee-list";
    }

}
