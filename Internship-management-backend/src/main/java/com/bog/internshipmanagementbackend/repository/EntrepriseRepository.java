package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,String> {
}
