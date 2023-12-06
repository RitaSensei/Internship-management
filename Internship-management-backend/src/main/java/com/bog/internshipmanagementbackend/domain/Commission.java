package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private int Type;
    private int Num_candidat;
    private String Avis;

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> candidats;
}
