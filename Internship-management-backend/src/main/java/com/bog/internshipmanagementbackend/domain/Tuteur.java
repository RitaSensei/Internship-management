package com.bog.internshipmanagementbackend.domain;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Tuteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private String prenom;

	@Column(nullable = false)
	private String sexe;

	@Column(nullable = false, unique = true)
	private String numPerso;

	@Column(nullable = false)
	private String idEntreprise;

	@OneToOne(mappedBy = "tuteur")
	private Stage stage;
}
