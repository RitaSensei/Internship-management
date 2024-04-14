package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Promo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annee;

	@Column(nullable = false)
	private int nbrInscrits;

	@Column(nullable = false)
	private int nbrReçus;

	@OneToOne
	@JoinColumn(name = "idEtudiant")
	private Etudiant etudiant;

	@OneToOne
	@JoinColumn(name = "idProf")
	private Professeur professeur;
}

