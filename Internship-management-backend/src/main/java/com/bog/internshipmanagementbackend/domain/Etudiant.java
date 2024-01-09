package com.bog.internshipmanagementbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant extends User {

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

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String mentionExamen;

    @Column(nullable = false)
    private Boolean completionStage;

    @OneToOne(mappedBy = "etudiant")
    private Stage stage;

    @OneToOne
    @JoinColumn(name = "annee")
    private Promo promo;
    public Etudiant(String username, String email, String password) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
    }
}