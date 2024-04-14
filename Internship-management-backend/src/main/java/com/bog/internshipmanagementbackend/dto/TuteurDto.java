package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TuteurDto {
    private String id;
    private String nom;
    private String prenom;
    private String sexe;
    private String numPerso;
    private String idEntreprise;
    private Long stageId;
}
