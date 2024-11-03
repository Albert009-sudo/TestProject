package com.example.testproject.DTO;

import com.example.testproject.Entity.Address;
import com.example.testproject.Entity.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class AddressDTO {
    private Long id;
    private String type;
    private String value;
    private Customer customer;

    public AddressDTO toDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .type(address.getType())
                .value(address.getValue())
                .build();
    }

    public Address toEntity(AddressDTO addressDTO) {
        return Address.builder()
                .id(addressDTO.getId())
                .type(addressDTO.getType())
                .value(addressDTO.getValue())
                .build();
    }
}
