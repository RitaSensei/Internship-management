package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor,String> {
    List<Professor> findProfessorByNom(String nom);

}
