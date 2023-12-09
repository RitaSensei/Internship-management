package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CandidatDto {
    private Long Id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private Date Date_naissance;
    private String Sexe;
    private String Num_perso;
    private String Dossier1;
    private String Dossier2;
}
