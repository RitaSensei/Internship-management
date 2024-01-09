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
	private String id;

	@Column(nullable = false, unique = true)
	private String raisonSociale;

	@Column(nullable = false)
	private String adresse;

	@Column(nullable = false)
	private String formeJuridique;

	@Column(nullable = false)
	private String ville;

	@Column(nullable = false, unique = true)
	private String numContact;

	@Column(nullable = false, unique = true)
	private String numStandard;

	@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
	private List<Stage> stages;
}
