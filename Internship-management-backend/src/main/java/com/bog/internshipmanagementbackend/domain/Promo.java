package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Promo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Année;
	private int Nbr_inscrits;
	private int Nbr_reçus;
	
}
