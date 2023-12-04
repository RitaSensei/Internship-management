package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private Date Date_embauche;
    private Date Date_depart;
}
