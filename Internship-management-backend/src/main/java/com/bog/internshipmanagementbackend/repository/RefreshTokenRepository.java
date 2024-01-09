package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByAdmin(Admin admin);
    @Modifying
    int deleteByCandidat(Candidat candidat);
    @Modifying
    int deleteByEtudiant(Etudiant etudiant);
    @Modifying
    int deleteByProfesseur(Professeur professeur);
}
