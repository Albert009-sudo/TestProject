package com.example.testproject.DTO;

import com.example.testproject.Entity.Address;
import com.example.testproject.Entity.Customer;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<Address> addresses;

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .build();
    }

}
