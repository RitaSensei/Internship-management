package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.ProfesseurDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface ProfesseurService {
    ProfesseurDto addProfesseur(ProfesseurDto professeurDto);
    ProfesseurDto findProfesseurById(long id);
    List<ProfesseurDto> findAllProfesseurs();
    List<ProfesseurDto> findProfesseurByPromo(int annee);
    ProfesseurDto updateProfesseur(ProfesseurDto etudiantDto, long id) throws EntityNotFoundException;
    ProfesseurDto deleteProfesseur(long id);
    ProfesseurDto deleteAllProfesseurs();

}
