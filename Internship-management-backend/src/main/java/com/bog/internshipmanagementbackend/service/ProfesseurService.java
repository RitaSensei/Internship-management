package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.ProfesseurDto;

import java.util.List;

public interface ProfesseurService {
    List<ProfesseurDto> findProfesseurByPromo(int annee);
}
