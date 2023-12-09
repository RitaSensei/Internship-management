package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProfesseurDto {
    private String Id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private Date Date_embauche;
    private Date Date_depart;
}
