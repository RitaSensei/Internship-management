package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Professeur;
import com.bog.internshipmanagementbackend.dto.ProfesseurDto;
import com.bog.internshipmanagementbackend.repository.ProfesseurRepository;
import com.bog.internshipmanagementbackend.service.ProfesseurService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private ModelMapper Mapper;
    private ProfesseurRepository professeurRepository;

    @Override
    @Transactional
    public ProfesseurDto addProfesseur(ProfesseurDto professeurDto) {
        Professeur professeur= Mapper.map(professeurDto, Professeur.class);
        Professeur savedProfesseur= professeurRepository.save(professeur);
        return Mapper.map(savedProfesseur, ProfesseurDto.class);
    }

    @Override
    public ProfesseurDto findProfesseurById(long id) {
        Professeur professeur = professeurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professeur not found with id: " + id));
        return Mapper.map(professeur,ProfesseurDto.class);
    }

    @Override
    public List<ProfesseurDto> findAllProfesseurs() throws EntityNotFoundException {
        List<Professeur> professeurs = professeurRepository.findAll();
        if(professeurs.isEmpty()){
            throw new EntityNotFoundException("Liste des profs est vide");
        }else {
            return professeurs
                    .stream()
                    .map(element -> Mapper.map(element, ProfesseurDto.class))
                    .collect(Collectors.toList());
        }
    }
    @Transactional
    @Override
    public ProfesseurDto updateProfesseur(ProfesseurDto professeurDto, long id) throws EntityNotFoundException {            //UPDATE
        Professeur professeur = Mapper.map(professeurDto, Professeur.class);
        if (!professeurRepository.existsById(id)) {
            throw new EntityNotFoundException("Professeur not found with id : "+id);
        }
        Professeur savedProfesseur =professeurRepository.save(professeur);
        return Mapper.map(savedProfesseur,ProfesseurDto.class);
    }

    @Override
    public List<ProfesseurDto> findProfesseurByPromo(int annee) {
        List<Professeur> professeurs=professeurRepository.findByPromoAnnee(annee);
        List<ProfesseurDto> professeurDtos=professeurs
                .stream()
                .map(professeur-> Mapper.map(professeur,ProfesseurDto.class))
                .collect(Collectors.toList());
        return professeurDtos;
    }

    @Transactional
    public ProfesseurDto deleteProfesseur(long id) throws EntityNotFoundException {
        if (professeurRepository.existsById(id)) {
            professeurRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Professeur not found with id :"+id);
        }
        return null;
    }

    @Transactional
    public ProfesseurDto deleteAllProfesseurs() throws EntityNotFoundException {
        if (professeurRepository.count()>0) {
            professeurRepository.deleteAll();
        } else {
            throw new EntityNotFoundException("No professeurs found to delete");
        }
        return null;
    }

}
