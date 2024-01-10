package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur extends User {

    //    @Column(nullable = false)
    private String adresse;

    //    @Column(nullable = false)
    private Date dateEmbauche;

    private Date dateDepart;

    @OneToOne(mappedBy = "professeur") // Use the field name in the Promo entity
    private Promo promo;
    public Professeur(String username, String email, String password) {
        super(username, email, password);
    }

    public Professeur(String nom, String prenom, String username, String email, String password) {
        super(nom,prenom,username, email, password);
    }
}
