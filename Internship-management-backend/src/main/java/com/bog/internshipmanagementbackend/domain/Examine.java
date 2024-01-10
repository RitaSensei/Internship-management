package com.bog.internshipmanagementbackend.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examine implements Serializable {

    @EmbeddedId
    private ExamineId id;

    @Column(nullable = false)
    private Date dateExamen;

    @ManyToOne
    @MapsId("commissionId")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "idCommission")
    private Commission commission;

    @ManyToOne
    @MapsId("candidatId")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "numCandidat")
    private Candidat candidat;

    @Embeddable
    @Data @NoArgsConstructor @AllArgsConstructor
    public static class ExamineId implements Serializable {
        @Column(name = "numCandidat")
        private Long candidatId;

        @Column(name = "idCommission")
        private Long commissionId;
    }
}
