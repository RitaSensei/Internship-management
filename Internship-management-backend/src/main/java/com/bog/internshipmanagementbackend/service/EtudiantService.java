package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.EtudiantDto;

import java.util.List;

public interface EtudiantService {
    EtudiantDto addEtudiant(EtudiantDto etudiantDto);
    EtudiantDto findEtudiantById(int id);
    List<EtudiantDto> findAllEtudiants();
    List<EtudiantDto> findEtudiantsByPromo(int annee);
    EtudiantDto updateEtudiant(EtudiantDto etudiantDto, int id) /*throws EntityNotFoundException*/;
    EtudiantDto deleteEtudiant(int id);
    EtudiantDto deleteAllEtudiants();
    EtudiantDto etudiantLogin(String email, String password);

}
