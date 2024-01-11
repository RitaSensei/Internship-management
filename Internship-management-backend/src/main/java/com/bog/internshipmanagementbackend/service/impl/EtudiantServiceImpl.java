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
    public EtudiantDto findEtudiantById(long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found with id: " + id));
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
    @Transactional
    public EtudiantDto updateEtudiant(EtudiantDto etudiantDto, long id) throws EntityNotFoundException {
        Etudiant etudiant = Mapper.map(etudiantDto, Etudiant.class);
        if (!etudiantRepository.existsById(id)) {
            throw new EntityNotFoundException("Etudiant not found with id: " + id);
        }
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return Mapper.map(savedEtudiant, EtudiantDto.class);
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
    public EtudiantDto deleteEtudiant(long id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Etudiant not found with id: " + id);
        }
        return null;
    }

    @Override
    @Transactional
    public EtudiantDto deleteAllEtudiants() {
        if (etudiantRepository.count() > 0) {
            etudiantRepository.deleteAll();
        } else {
            throw new EntityNotFoundException("No etudiants found to delete.");
        }
        return null;
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

}
