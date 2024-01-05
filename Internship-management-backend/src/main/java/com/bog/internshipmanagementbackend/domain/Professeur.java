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
    private String Id;
    @Column(nullable = false)
    private String Nom;
    @Column(nullable = false)
    private String Prenom;
    @Column(nullable = false)
    private String Adresse;
    @Column(nullable = false)
    private Date Date_embauche;
    @Column(nullable = false)
    private Date Date_depart;

    @OneToOne(mappedBy = "professeur") // Use the field name in the Promo entity
    private Promo promo;
}
