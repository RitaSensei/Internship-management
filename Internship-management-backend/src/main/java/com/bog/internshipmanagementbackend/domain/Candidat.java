package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private Date dateNaissance;
    @Column(nullable = false)
    private String sexe;
    @Column(nullable = false,unique = true)
    private String numPerso;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String dossier1;
    private String dossier2;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> commissions;
}
