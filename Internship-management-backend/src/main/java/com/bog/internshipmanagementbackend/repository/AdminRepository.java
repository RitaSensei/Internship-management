package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
//    Admin findByEmailAndAndPassword(String email, String password);
}
