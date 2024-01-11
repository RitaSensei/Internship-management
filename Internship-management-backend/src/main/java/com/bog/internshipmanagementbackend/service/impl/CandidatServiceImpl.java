package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Candidat;
import com.bog.internshipmanagementbackend.dto.CandidatDto;
import com.bog.internshipmanagementbackend.repository.CandidatRepository;
import com.bog.internshipmanagementbackend.service.CandidatService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidatServiceImpl implements CandidatService {
    private CandidatRepository candidatRepository;
    private ModelMapper Mapper;

    @Override
    @Transactional
    public CandidatDto addCandidat(CandidatDto CandidatDto) {
        Candidat candidat = Mapper.map(CandidatDto,Candidat.class);
        Candidat savedCandidat = candidatRepository.save(candidat);
        return Mapper.map(savedCandidat, CandidatDto.class);
    }

    @Override
    public CandidatDto findCandidatById(long id) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidat not found with id: " + id));
        return Mapper.map(candidat,CandidatDto.class);
    }

    @Override
    public List<CandidatDto> findAllCandidats() {
        List<Candidat> Candidats = candidatRepository.findAll();
        List<CandidatDto> CandidatsDTOs = Candidats
                .stream()
                .map(Candidat -> Mapper.map(Candidat, CandidatDto.class))
                .collect(Collectors.toList());
        return CandidatsDTOs;
    }

    @Override
    @Transactional
    public CandidatDto updateCandidat(CandidatDto CandidatDto, long id) throws EntityNotFoundException {
        Candidat Candidat = Mapper.map(CandidatDto,Candidat.class);
        if (!candidatRepository.existsById(id)) {
            throw new EntityNotFoundException("Candidat not found with id: " + id);
        }
        Candidat save = candidatRepository.save(Candidat);
        return Mapper.map(save,CandidatDto.class);
    }

    @Override
    @Transactional
    public CandidatDto deleteCandidat(long id) {
        if (candidatRepository.existsById(id)) {
            candidatRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Candidat not found with id: " + id);
        }
        return null;
    }

    @Override
    @Transactional
    public CandidatDto deleteAllCandidats() {
        if(candidatRepository.count()>0) {
            candidatRepository.deleteAll();
        } else {
            throw new EntityNotFoundException("No candidats found to delete");
        }
        return null;
    }

    public CandidatDto findByEmail(String email) {
        Candidat candidat = candidatRepository.findByEmail(email);
        return Mapper.map(candidat, CandidatDto.class);
    }

    public CandidatDto findByNumPerso(String numPerso) {
        Candidat candidat = candidatRepository.findByNumPerso(numPerso);
        return Mapper.map(candidat, CandidatDto.class);
    }

    public CandidatDto findByEmailAndNumPerso(String email, String numPerso) {
        Candidat candidat = candidatRepository.findByEmailAndNumPerso(email, numPerso);
        return Mapper.map(candidat, CandidatDto.class);
    }

}
