package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission,String> {
}
