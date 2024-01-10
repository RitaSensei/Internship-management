package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findById(Long id);
    List<Admin> findAllById(Iterable<Long> ids);
    Admin findByEmailAndNumPerso(String email, String numPerso);
    Admin findByEmail(String email);
    Admin findByNumPerso(String numPerso);
    Optional<Admin> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Admin findByEmailAndAndPassword(String email, String password);
//    List<Admin> findByPromoAnnee(int annee);
//   Admin findByEmailAndAndPassword(String email, String password);
}
