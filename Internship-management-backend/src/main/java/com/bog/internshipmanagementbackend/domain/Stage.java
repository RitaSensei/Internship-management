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
	@Column(name = "numStage")
	private String id;

	@Column(nullable = false)
	private String idProf;

	@Column(nullable = false)
	private int promo;

	@Column(nullable = false)
	private int annee;

	@Column(nullable = false)
	private int type;

	@Column(nullable = false)
	private String rapportPath;

	@Column(nullable = false)
	private String conventionPath;

	@Column(nullable = false)
	private String attestationPath;

	@Column(nullable = false)
	private String ficheDeStagePath;

	@Column(nullable = false)
	private String ficheEvaluationPath;

	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	@OneToOne
	@JoinColumn(name = "idEtudiant")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Etudiant etudiant;

	@OneToOne
	@JoinColumn(name = "idTuteur")
	private Tuteur tuteur;

	@OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Exige> competences;
}
