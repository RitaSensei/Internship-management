package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Candidat;
import com.bog.internshipmanagementbackend.domain.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommissionRepository extends JpaRepository<Commission,Long> {
    Optional<Commission> findById(Long id);
    List<Commission> findAllByType(int type);
    List<Commission> findAllByNumCandidat(Long numCandidat);
    List<Commission> findAllByAvis(String avis);
}
