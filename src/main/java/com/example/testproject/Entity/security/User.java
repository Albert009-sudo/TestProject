package com.example.testproject.Entity.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "userIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "userIdSeq",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    @JsonBackReference
    private String password;
    @Column(name = "active")
    private Boolean active;
}
