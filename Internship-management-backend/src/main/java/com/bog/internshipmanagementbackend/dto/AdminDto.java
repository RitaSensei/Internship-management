package com.bog.internshipmanagementbackend.dto;

import com.bog.internshipmanagementbackend.domain.Role;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AdminDto {
    private Long id;
    private String nom;
    private String prenom;
    private String numPerso;
    private String username;
    private String email;
    private String password;
    private Role role;
}
