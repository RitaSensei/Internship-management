package com.bog.internshipmanagementbackend.domain;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String Id;
	@Column(nullable = false)
	private String Raison_sociale;
	@Column(nullable = false)
	private String Adresse;
	@Column(nullable = false)
	private String Forme_juridique;
	@Column(nullable = false)
	private String Ville;
	@Column(nullable = false)
	private String Num_contact;
	@Column(nullable = false)
	private String Num_standard;

	@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
	private List<Stage> stages;
}
