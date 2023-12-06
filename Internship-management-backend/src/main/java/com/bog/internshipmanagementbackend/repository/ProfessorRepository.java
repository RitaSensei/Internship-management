package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professeur,String> {
    List<Professeur> findProfessorByNom(String nom);

}
