package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Candidat;
import com.bog.internshipmanagementbackend.dto.CandidatDto;
import com.bog.internshipmanagementbackend.repository.CandidatRepository;
import com.bog.internshipmanagementbackend.service.CandidatService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CandidatServiceImpl implements CandidatService {
//    private CandidatRepository CandidatRepository;
//    private ModelMapper Mapper;
//
//    @Override
//    public CandidatDto addCandidat(CandidatDto CandidatDto) {
//        Candidat candidat = Mapper.map(CandidatDto,Candidat.class);
//        Candidat savedCandidat = CandidatRepository.save(candidat);
//        return Mapper.map(savedCandidat, CandidatDto.class);
//
//    }
//
//    @Override
//    public CandidatDto findCandidatById(int id) {
//        Candidat candidat = CandidatRepository.findById((long) id).orElse(null);
//        return Mapper.map(candidat,CandidatDto.class);
//
//    }
//
//    @Override
//    public List<CandidatDto> findAllCandidats() {
//        List<Candidat> Candidats = CandidatRepository.findAll();
//        List<CandidatDto> CandidatsDTOs = Candidats
//                .stream()
//                .map(Candidat -> Mapper.map(Candidat, CandidatDto.class))
//                .collect(Collectors.toList());
//        return CandidatsDTOs;
//    }
//
//
//    @Override
//    public CandidatDto updateCandidat(CandidatDto CandidatDto, int id) throws EntityNotFoundException {
//        Candidat Candidat = Mapper.map(CandidatDto,Candidat.class);
//        Candidat save = CandidatRepository.save(Candidat);
//        return Mapper.map(save,CandidatDto.class);
//    }
//
//    @Override
//    public void deleteCandidat(int id) {
//        CandidatRepository.deleteById((long) id);
//    }
//
//    @Override
//    public void deleteAllCandidats() {
//        CandidatRepository.deleteAll();
//
//    }
//
//    public CandidatDto findByEmail(String email) {
//        Candidat candidat = CandidatRepository.findByEmail(email);
//        return Mapper.map(candidat, CandidatDto.class);
//    }
//
//    public CandidatDto findByNumPerso(String numPerso) {
//        Candidat candidat = CandidatRepository.findByNumPerso(numPerso);
//        return Mapper.map(candidat, CandidatDto.class);
//    }
//
//    public CandidatDto findByEmailAndNumPerso(String email, String numPerso) {
//        Candidat candidat = CandidatRepository.findByEmailAndNumPerso(email, numPerso);
//        return Mapper.map(candidat, CandidatDto.class);
//    }
//
//
//    @Override
//    public CandidatDto CandidatLogin(String email, String password) {
//        // TODO Auto-generated method stub
//        return null;
//    }
}
