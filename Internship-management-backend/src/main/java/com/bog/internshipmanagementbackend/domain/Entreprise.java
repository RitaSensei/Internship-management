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
public class Entreprise {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private String Id;
	 private String Raison_sociale;
	 private String Adresse;
	 private String Forme_juridique;
	 private String Ville;
	 private String Num_contact;
	 private String Num_standard;


}
