package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.ERole;
import com.bog.internshipmanagementbackend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
    Optional<Role> findByNom(ERole nom);
}
