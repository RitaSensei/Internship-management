package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EtudiantDto {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private Date dateNaissance;
    private String sexe;
    private String numPerso;
    private String username;
    private String email;
    private String password;
    private String role;
    private String mentionExamen;
    private Boolean completionStage;
    private Long numStage;
    private Long annee;
}
