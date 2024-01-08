package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Etudiant;
import com.bog.internshipmanagementbackend.dto.EtudiantDto;
import com.bog.internshipmanagementbackend.repository.EtudiantRepository;
import com.bog.internshipmanagementbackend.service.EtudiantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private ModelMapper Mapper;

    @Override
    @Transactional
    public EtudiantDto addEtudiant(EtudiantDto etudiantDto) {
        Etudiant etudiant = Mapper.map(etudiantDto,Etudiant.class);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return Mapper.map(savedEtudiant, EtudiantDto.class);

    }

    @Override
    public EtudiantDto findEtudiantById(int id) {
        Etudiant etudiant = etudiantRepository.findById((long) id).orElse(null);
        return Mapper.map(etudiant,EtudiantDto.class);

    }

    @Override
    public List<EtudiantDto> findAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<EtudiantDto> etudiantsDTOs = etudiants
                .stream()
                .map(etudiant -> Mapper.map(etudiant, EtudiantDto.class))
                .collect(Collectors.toList());
        return etudiantsDTOs;
    }

    @Override
    public List<EtudiantDto> findEtudiantsByPromo(int annee) {
        List<Etudiant> etudiants = etudiantRepository.findByPromoAnnee(annee);
        List<EtudiantDto> etudiantsDTOs = etudiants
                .stream()
                .map(etudiant -> Mapper.map(etudiant, EtudiantDto.class))
                .collect(Collectors.toList());
        return etudiantsDTOs;
    }

    @Override
    @Transactional
    public EtudiantDto updateEtudiant(EtudiantDto etudiantDto, int id) throws EntityNotFoundException {
        Etudiant etudiant = Mapper.map(etudiantDto,Etudiant.class);
        Etudiant save = etudiantRepository.save(etudiant);
        return Mapper.map(save,EtudiantDto.class);
    }

    @Override
    @Transactional
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById((long) id);
    }

    @Override
    @Transactional
    public void deleteAllEtudiants() {
        etudiantRepository.deleteAll();

    }

    public EtudiantDto findByEmail(String email) {
        Etudiant etudiant = etudiantRepository.findByEmail(email);
        return Mapper.map(etudiant, EtudiantDto.class);
    }

    public EtudiantDto findByNumPerso(String numPerso) {
        Etudiant etudiant = etudiantRepository.findByNumPerso(numPerso);
        return Mapper.map(etudiant, EtudiantDto.class);
    }

    public EtudiantDto findByEmailAndNumPerso(String email, String numPerso) {
        Etudiant etudiant = etudiantRepository.findByEmailAndNumPerso(email, numPerso);
        return Mapper.map(etudiant, EtudiantDto.class);
    }

    public EtudiantDto etudiantLogin(String email, String password) {
        /*Etudiant etudiant = etudiantRepository.findByEmailAndPassword(email, password);
        return Mapper.map(etudiant, EtudiantDto.class);*/
        return null;
    }
}
