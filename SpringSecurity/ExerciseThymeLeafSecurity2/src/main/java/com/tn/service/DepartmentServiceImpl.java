package com.tn.service;


import com.tn.repository.DepartmentRepository;
import com.tn.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }
    public void add(Department product){
        departmentRepository.save(product);
    }

}
