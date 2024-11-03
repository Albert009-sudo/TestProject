package com.example.testproject.DTO;

import com.example.testproject.Entity.security.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private Boolean active;

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .active(user.getActive())
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .active(userDTO.getActive())
                .build();
    }
}
