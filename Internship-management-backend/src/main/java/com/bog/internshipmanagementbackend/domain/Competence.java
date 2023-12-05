package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Competence {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private String Code;
	private String Libelle;
	private String Description;
	
}
