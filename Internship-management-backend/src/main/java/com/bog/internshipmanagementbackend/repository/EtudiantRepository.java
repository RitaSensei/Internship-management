package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findById(int id);
    List<Etudiant> findAllById(Iterable<Long> id);
    Etudiant findByEmailAndPassword(String email, String password);
    Etudiant findByEmail(String email);
    Etudiant findByPassword(String password);
    List<Etudiant> findByPromo(int annee);
}
