package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur,String> {
}
