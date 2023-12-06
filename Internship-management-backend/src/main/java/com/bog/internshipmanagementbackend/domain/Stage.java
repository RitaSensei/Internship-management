package com.bog.internshipmanagementbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Stage {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private String Id;
	 private String Raison_sociale;
	 private String Adresse;
	 private String Forme_juridique;
	 private String Ville;
	 private String Num_contact;
	 private String Num_standard;

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
