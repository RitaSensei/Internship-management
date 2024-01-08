package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.EtudiantDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface EtudiantService {
    EtudiantDto addEtudiant(EtudiantDto etudiantDto);
    EtudiantDto findEtudiantById(int id);
    List<EtudiantDto> findAllEtudiants();
    List<EtudiantDto> findEtudiantsByPromo(int annee);
    EtudiantDto updateEtudiant(EtudiantDto etudiantDto, int id) throws EntityNotFoundException;
    void deleteEtudiant(int id);
    void deleteAllEtudiants();
    EtudiantDto etudiantLogin(String email, String password);
}
