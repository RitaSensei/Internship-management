package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.CandidatDto;
import com.bog.internshipmanagementbackend.dto.CommissionDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface CommissionService {
    CommissionDto addCommission(CommissionDto CommissionDto);
    CommissionDto findCommissionById(int id);
    List<CommissionDto> findAllCommissions();
    List<CommissionDto> findCommissionsByType(int annee);
    CommissionDto updateCommission(CommissionDto CommissionDto, int id) throws EntityNotFoundException;
    void deleteCommission(int id);
    void deleteAllCommissions();
    CandidatDto findCandidatByCommissionId(int id);
    /*ProfesseurDto findProfesseursByCommissionId(int id);*/
}
