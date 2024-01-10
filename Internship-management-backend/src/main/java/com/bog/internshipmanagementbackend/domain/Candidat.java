package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidat extends User {

    //    @Column(nullable = false)
    private String adresse;

    //    @Column(nullable = false)
    private Date dateNaissance;

    //    @Column(nullable = false)
    private String sexe;

    @Column(nullable = false,unique = true)
    private String numPerso;

    //    @Column(nullable = false)
    private String dossier1;

    private String dossier2;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> commissions;
    public Candidat(String username, String email, String password) {
        super(username, email, password);
    }

    public Candidat(String nom, String prenom, String numPerso, String username, String email, String password) {
        super(nom,prenom,username, email, password);
        this.numPerso=numPerso;
    }
}
