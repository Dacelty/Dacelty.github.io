package com.example.springRestCrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cho getter setter
public class EmployeeDTO {
    private String firstName;
    private String lastName;

    //dto không cần constructor
}
