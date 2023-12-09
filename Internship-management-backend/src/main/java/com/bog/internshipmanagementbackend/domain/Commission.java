package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    @Column(nullable = false)
    private int Type;
    @Column(nullable = false)
    private int Num_candidat;
    @Column(nullable = false)
    private String Avis;

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> candidats;
}
