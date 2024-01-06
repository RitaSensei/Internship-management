package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professeur,String> {
    Optional<Professeur> findById(String id);
    Professeur findByEmail(String email);
    List<Professeur> findByNom(String nom);
    List<Professeur> findByPrenom(String prenom);
    List<Professeur> findByDateEmbaucheAfter(Date dateE);
    List<Professeur> findByDateDepartAfter(Date dateD);
}
