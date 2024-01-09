package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Optional<Professeur> findById(Long id);
    Professeur findByEmail(String email);
    List<Professeur> findByNom(String nom);
    List<Professeur> findByPrenom(String prenom);
    List<Professeur> findByDateEmbaucheAfter(Date dateE);
    List<Professeur> findByDateDepartAfter(Date dateD);
    Optional<Professeur> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
