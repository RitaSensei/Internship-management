package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.EtudiantDto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

public interface EtudiantService {
    EtudiantDto addEtudiant(EtudiantDto etudiantDto);
    EtudiantDto findEtudiantById(long id);
    List<EtudiantDto> findAllEtudiants();
    EtudiantDto updateEtudiant(EtudiantDto etudiantDto, long id) throws EntityNotFoundException;
    List<EtudiantDto> findEtudiantsByPromo(int annee);
    EtudiantDto deleteEtudiant(long id);
    EtudiantDto deleteAllEtudiants();
}

