package com.bog.internshipmanagementbackend.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Tuteur {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private String Id;
	 private String Nom;
	 private String Prenom;
	 private String Sexe;
	 private Date Num_perso;
	 private String Id_entreprise;
}
