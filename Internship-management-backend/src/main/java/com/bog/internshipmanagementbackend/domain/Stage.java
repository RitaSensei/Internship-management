package com.bog.internshipmanagementbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Stage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_stage")
	private String Id;
	@Column(nullable = false)
	private String id_prof;
	@Column(nullable = false)
	private int promo;
	@Column(nullable = false)
	private int annee;
	@Column(nullable = false)
	private int type;
	@Column(nullable = false)
	@Lob
	private String rapport;
	@Column(nullable = false)
	@Lob
	private String convention;
	@Column(name = "fiche_de_stage",nullable = false)
	@Lob
	private String ficheDeStage;
	@Column(name = "fiche_evaluation",nullable = false)
	@Lob
	private String attestation;


	@ManyToOne
	@JoinColumn(name = "id_entreprise")
	private Entreprise entreprise;

	@OneToOne
	@JoinColumn(name = "id_etudiant")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Etudiant etudiant;

	@OneToOne
	@JoinColumn(name = "id_tuteur")
	private Tuteur tuteur;

	@OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Exige> competences;
}
