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
    private int niveauExige;

    @Column(nullable = false)
    private float acquisitionCompetence;

    @ManyToOne
    @MapsId("codeCompetence")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "codeCompetence")
    private Competence competence;

    @ManyToOne
    @MapsId("idStage")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "idStage")
    private Stage stage;

    @Embeddable
    @Data @NoArgsConstructor @AllArgsConstructor
    public static class ExigeId implements Serializable {
        @Column(name = "codeCompetence")
        private String codeCompetence;  // Corresponding to the Competence primary key

        @Column(name = "idStage")
        private String idStage;  // Corresponding to the Stage primary key
    }
}


