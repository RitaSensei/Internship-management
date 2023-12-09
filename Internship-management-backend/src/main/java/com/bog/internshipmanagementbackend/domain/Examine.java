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
    private Date Date_examen;

    @ManyToOne
    @MapsId("Id")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "id_commission")
    private Commission commission;

    @ManyToOne
    @MapsId("id_candidat")  // This maps to the field name in the ExigeId class
    @JoinColumn(name = "num_candidat")
    private Candidat candidat;

    @Embeddable
    @Data @NoArgsConstructor @AllArgsConstructor
    public static class ExamineId implements Serializable {
        private String Num_candidat;
        private String Id_commission;
    }
}
