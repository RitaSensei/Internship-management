package com.bog.internshipmanagementbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
