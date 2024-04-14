package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {
    Optional<Candidat> findById(Long id);
    List<Candidat> findAllById(Iterable<Long> ids);
    Candidat findByEmailAndNumPerso(String email, String numPerso);
    Candidat findByEmail(String email);
    Candidat findByNumPerso(String numPerso);
    Optional<Candidat> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
