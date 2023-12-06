package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private Date Date_naissance;
    private String Sexe;
    private String Num_perso;
    private String Dossier1;
    private String Dossier2;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> commissions;

}
