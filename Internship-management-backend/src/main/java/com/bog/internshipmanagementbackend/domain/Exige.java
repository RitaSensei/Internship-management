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
    @Column(nullable = false)
    private int Niveau_exige;
    @Column(nullable = false)
    private float Acquisition_competence;

    @ManyToOne
    @MapsId("codeCompetence")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "code_competence")
    private Competence competence;

    @ManyToOne
    @MapsId("idStage")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "id_stage")
    private Stage stage;

    @Embeddable
    @Data @NoArgsConstructor @AllArgsConstructor
    public static class ExigeId implements Serializable {
        @Column(name = "code_competence")
        private String codeCompetence;  // Corresponding to the Competence primary key

        @Column(name = "id_stage")
        private String idStage;  // Corresponding to the Stage primary key
    }
}


