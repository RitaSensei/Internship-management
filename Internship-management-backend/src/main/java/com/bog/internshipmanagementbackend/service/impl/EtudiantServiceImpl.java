package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.dto.EtudiantDto;
import com.bog.internshipmanagementbackend.repository.EtudiantRepository;
import com.bog.internshipmanagementbackend.service.EtudiantService;

import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    @Override
    public EtudiantDto addEtudiant(EtudiantDto etudiantDto) {
        return null;
    }

    @Override
    public EtudiantDto findEtudiantById(int id) {
        return null;
    }

    @Override
    public List<EtudiantDto> findAllEtudiants() {
        return null;
    }

    @Override
    public List<EtudiantDto> findEtudiantsByPromo(int annee) {
        return null;
    }

    @Override
    public EtudiantDto updateEtudiant(EtudiantDto etudiantDto, int id) /*throws EntityNotFoundException*/ {
        return null;
    }

    @Override
    public EtudiantDto deleteEtudiant(int id) {
        return null;
    }

    @Override
    public EtudiantDto deleteAllEtudiants() {
        return null;
    }

    @Override
    public EtudiantDto etudiantLogin(String email, String password) {
        return null;
    }
}
