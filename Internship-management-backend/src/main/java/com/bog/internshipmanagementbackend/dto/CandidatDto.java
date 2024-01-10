package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CandidatDto {
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
    private String dossier1;
    private String dossier2;
    private List<Long> commissionIds;
}
