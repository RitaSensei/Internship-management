package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Commission;
import com.bog.internshipmanagementbackend.dto.CandidatDto;
import com.bog.internshipmanagementbackend.dto.CommissionDto;
import com.bog.internshipmanagementbackend.repository.CommissionRepository;
import com.bog.internshipmanagementbackend.service.CommissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommissionServiceImpl implements CommissionService {
    private CommissionRepository commissionRepository;
    private ModelMapper Mapper;

    @Override
    public CommissionDto addCommission(CommissionDto CommissionDto) {
        Commission commission = Mapper.map(CommissionDto,Commission.class);
        Commission savedCommission = commissionRepository.save(commission);
        return Mapper.map(savedCommission, CommissionDto.class);

    }

    public CommissionDto findCommissionById(int id) {
        Commission commission = commissionRepository.findById((long) id).orElse(null);
        return Mapper.map(commission,CommissionDto.class);

    }

    public List<CommissionDto> findAllCommissions(){
        List<Commission> commissions = commissionRepository.findAll();
        List<CommissionDto> commissionsDTOs = commissions
                .stream()
                .map(commission -> Mapper.map(commission, CommissionDto.class))
                .collect(Collectors.toList());
        return commissionsDTOs;
    }

    public List<CommissionDto> findCommissionsByType(int type){
        List<Commission> commissions = commissionRepository.findAllByType(type);
        List<CommissionDto> commissionsDTOs = commissions
                .stream()
                .map(commission -> Mapper.map(commission, CommissionDto.class))
                .collect(Collectors.toList());
        return commissionsDTOs;
    }

    public CommissionDto updateCommission(CommissionDto commissionDto, int id) throws EntityNotFoundException {
        Commission commission = Mapper.map(commissionDto,Commission.class);
        Commission save = commissionRepository.save(commission);
        return Mapper.map(save,CommissionDto.class);
    }

    public void deleteCommission(int id) {
        commissionRepository.deleteById((long) id);
    }

    public void deleteAllCommissions() {
        commissionRepository.deleteAll();
    }
    public CandidatDto findCandidatByCommissionId(int id) {
    	/*Commission commission = commissionRepository.findById((long) id).orElse(null);
    	return Mapper.map(commission,EtudiantDto.class);*/
        return null;
    }
}
