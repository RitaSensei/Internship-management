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
	private String Id;
	@Column(nullable = false)
	private String Nom;
	@Column(nullable = false)
	private String Prenom;
	@Column(nullable = false)
	private String Sexe;
	@Column(nullable = false)
	private Date Num_perso;
	@Column(nullable = false)
	private String Id_entreprise;

	@OneToOne(mappedBy = "tuteur")
	private Stage stage;
}
