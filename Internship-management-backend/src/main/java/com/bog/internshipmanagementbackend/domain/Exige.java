package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Exige implements Serializable {

    @EmbeddedId
    private ExigeId id;
    private int Niveau_exige;
    private float Acquisition_competence;

    @ManyToOne
    @MapsId("Code")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "code_competence")
    private Competence competence;

    @ManyToOne
    @MapsId("Id")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "id_stage")
    private Stage stage;

    @Embeddable
    @Data @NoArgsConstructor @AllArgsConstructor
    public static class ExigeId implements Serializable {
        private String codeCompetence;  // Corresponding to the Competence primary key
        private String idStage;  // Corresponding to the Stage primary key
    }
}


