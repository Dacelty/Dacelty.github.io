package com.example.springRestCrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Builder;

@Data //cho getter setter
@AllArgsConstructor // cho constructor với tất cả arguments
@NoArgsConstructor // cho constructor với không có arguments
// không cần phải thêm getter setter cons với các anno này
public class Employee {
    private int id;
    private String firstName;
    private String lastName;


}
