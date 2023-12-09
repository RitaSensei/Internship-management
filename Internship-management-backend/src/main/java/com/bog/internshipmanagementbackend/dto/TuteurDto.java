package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TuteurDto {
    private String Id;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private Date Num_perso;
    private String Id_entreprise;
}
