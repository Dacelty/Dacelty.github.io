package com.example.springTHCRUD;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //cho getter setter
@AllArgsConstructor // cho constructor với tất cả arguments
@NoArgsConstructor // cho constructor với không có arguments
@Builder // cho builder
// không cần phải thêm getter setter cons với các anno này
public class CustomerPOJODTO {
    private String fullname;
    private String email;
    private long telephone;
}
