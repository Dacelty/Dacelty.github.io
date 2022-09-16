package com.example.springRestCrud;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpRepo {
    private ArrayList<Employee> emp = new ArrayList<>();
    @Autowired
    private EmployeeMapper EmpMapper;

    public ArrayList<Employee> Repo(){
        try {
            File file = ResourceUtils.getFile("src/main/resources/MOCK_DATA.json");
            ObjectMapper mapper = new ObjectMapper();
            emp.addAll(mapper.readValue(file, new TypeReference<ArrayList<Employee>>() {}));
            System.out.println("Đọc dữ liệu từ file thành công.");
            System.out.println("Các mảng từ đối tượng chính EMP.");
            for (Employee e:emp){
                System.out.println(e.getId() + " - " + e.getFirstName() + " - " + e.getLastName());
            }
//            System.out.println("----------------------------------");
//            System.out.println("Các mảng từ đối tượng DTO.");
//            ArrayList<EmployeeDTO> empDTO = EmpMapper.maptoDTO(emp);
//            for (EmployeeDTO e:empDTO){
//                System.out.println(e.getFirstName() + " - " + e.getLastName());
//            }
//            return empDTO;
            return emp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<EmployeeDTO> RepoDTO(){
        System.out.println("----------------------------------");
        System.out.println("Các mảng từ đối tượng DTO.");
        ArrayList<EmployeeDTO> empDTO = EmpMapper.maptoDTO(emp);
        for (EmployeeDTO e:empDTO){
            System.out.println(e.getFirstName() + " - " + e.getLastName());
        }
        return empDTO;

    }

}
