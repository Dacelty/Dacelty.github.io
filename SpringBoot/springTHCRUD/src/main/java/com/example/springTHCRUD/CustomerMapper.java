package com.example.springTHCRUD;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerPOJODTO customerToPOJO(Customer customer); // nếu không có anno thì sẽ map các trường có cùng tên
    Customer pojoToCustomer(CustomerPOJODTO pojo);
}
