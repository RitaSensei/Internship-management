package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Candidat;
import com.bog.internshipmanagementbackend.domain.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commission,Long> {
    List<Candidat> findAllByNumCandidat(Long numCandidat);
    List<Candidat> findAllByAvis(String avis);
}
