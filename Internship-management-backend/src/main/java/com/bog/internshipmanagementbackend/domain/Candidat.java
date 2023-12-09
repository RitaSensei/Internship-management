package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(nullable = false)
    private String Nom;
    @Column(nullable = false)
    private String Prenom;
    @Column(nullable = false)
    private String Adresse;
    @Column(nullable = false)
    private Date Date_naissance;
    @Column(nullable = false)
    private String Sexe;
    @Column(nullable = false,unique = true)
    private String Num_perso;
    @Column(nullable = false)
    private String Dossier1;
    private String Dossier2;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> commissions;

}
