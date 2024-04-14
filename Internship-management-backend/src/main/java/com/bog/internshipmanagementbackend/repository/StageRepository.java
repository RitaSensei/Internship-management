package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage,String> {
}
