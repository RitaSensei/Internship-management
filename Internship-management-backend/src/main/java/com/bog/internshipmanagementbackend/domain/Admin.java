package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Nom;

    @Column(nullable = false)
    private String Prenom;

    @Column(nullable = false)
    private String Role;

    @Column(unique=true,nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;
}
