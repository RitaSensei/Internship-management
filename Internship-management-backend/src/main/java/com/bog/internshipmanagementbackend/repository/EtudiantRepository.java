package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findById(Long id);
    List<Etudiant> findAllById(Iterable<Long> ids);
    Etudiant findByEmailAndNumPerso(String email, String numPerso);
    Etudiant findByEmail(String email);
    Etudiant findByNumPerso(String numPerso);
    List<Etudiant> findByPromoAnnee(int annee);
    Optional<Etudiant> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
