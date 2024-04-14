package com.bog.internshipmanagementbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

import java.util.List;

@Data
public class StageDto {
    private String id;
    private String idProf;
    private int promo;
    private int annee;
    private int type;
    private String rapportPath;
    private String conventionPath;
    private String attestationPath;
    private String ficheDeStagePath;
    private String ficheEvaluationPath;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String idEntreprise;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String idEtudiant;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String idTuteur;

    private List<Long> competenceIds;
}
