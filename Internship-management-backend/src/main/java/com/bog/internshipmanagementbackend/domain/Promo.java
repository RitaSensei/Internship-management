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
	private int Année;
	@Column(nullable = false)
	private int Nbr_inscrits;
	@Column(nullable = false)
	private int Nbr_reçus;

	@OneToOne(mappedBy = "etudiant")
	private Etudiant etudiant;

	@OneToOne
	@JoinColumn(name = "id_prof")
	private Professeur professeur;
}
