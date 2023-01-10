package com.tn.service;


import com.tn.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    void add(Department department);
}
