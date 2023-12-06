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
    private String Nom;
    private String Prenom;
    private String Adresse;
    private Date Date_naissance;
    private String Sexe;
    private String Num_perso;
//    private int Promo;
    private String Mention_examen;
    private Boolean Complétion_stage;

    @OneToOne(mappedBy = "etudiant")
    private Stage stage;

    @OneToOne
    @JoinColumn(name = "année")
    private Promo promo;
}