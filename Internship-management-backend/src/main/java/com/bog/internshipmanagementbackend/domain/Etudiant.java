package com.bog.internshipmanagementbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false, unique = true)
    private String numPerso;

    @Column(unique=true,nullable=false)
    private String email;

    @Column(nullable = false)
    private String mentionExamen;

    @Column(nullable = false)
    private Boolean completionStage;

    @OneToOne(mappedBy = "etudiant")
    private Stage stage;

    @OneToOne
    @JoinColumn(name = "annee")
    private Promo promo;
}