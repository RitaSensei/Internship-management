package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private Date dateEmbauche;

    private Date dateDepart;

    @OneToOne(mappedBy = "professeur") // Use the field name in the Promo entity
    private Promo promo;
}
