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
@Data @NoArgsConstructor @AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String Prenom;
	private String Adresse;
	private Date Date_naissance;
	private String Sexe;
	private String Num_perso;
	private int Promo;
	private String Mention_exam;
	private Boolean Completion_stage;
}
