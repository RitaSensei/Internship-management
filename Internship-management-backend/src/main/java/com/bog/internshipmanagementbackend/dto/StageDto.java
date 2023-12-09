package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

@Data
public class StageDto {
    private String Id;
    private String id_prof;
    private int promo;
    private int annee;
    private int type;
    private String rapport;
    private String convention;
    private String ficheDeStage;
    private String attestation;
}
