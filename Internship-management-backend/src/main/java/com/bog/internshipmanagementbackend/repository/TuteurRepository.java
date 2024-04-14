package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur,String> {
    Optional<Tuteur> findById(String id);
    Tuteur findByNumPerso(String numPerso);
    void deleteByIdEntreprise(String idEntreprise);
}
