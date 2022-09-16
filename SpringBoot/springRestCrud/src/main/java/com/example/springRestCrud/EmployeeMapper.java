package com.example.springRestCrud;

import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeDTO maptoDTO(Employee value);
    ArrayList<EmployeeDTO> maptoDTO1(ArrayList<Employee> employees);
    ArrayList<Employee> maptoMainOb(ArrayList<EmployeeDTO> employees);
}
