package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
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
    @Column(nullable = false)
    private String Num_perso;
    @Column(nullable = false)
    private String Mention_examen;
    @Column(nullable = false)
    private Boolean Complétion_stage;

    @OneToOne(mappedBy = "etudiant")
    private Stage stage;

    @OneToOne
    @JoinColumn(name = "année")
    private Promo promo;
}