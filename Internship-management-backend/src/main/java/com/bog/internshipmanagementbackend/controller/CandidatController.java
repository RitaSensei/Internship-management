package com.bog.internshipmanagementbackend.controller;

import com.bog.internshipmanagementbackend.dto.CandidatDto;
import com.bog.internshipmanagementbackend.service.CandidatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/candidats")
public class CandidatController {
    private final Logger logger = LoggerFactory.getLogger(EtudiantController.class);

    @Autowired
    private CandidatService candidatService;

    @GetMapping("/all")
    public List<CandidatDto> getCandidatsAll() {
        try {
            return candidatService.findAllCandidats();
        } catch (EntityNotFoundException e) {
            logger.error("Error while getting all candidats: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CandidatDto> getCandidat(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(candidatService.findCandidatById(id));
        } catch (EntityNotFoundException e) {
            logger.error("Candidat not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CandidatDto> editCandidat(@PathVariable Long id, @RequestBody CandidatDto candidatDto) {
        try {
            candidatDto = candidatService.updateCandidat(candidatDto, id);
            return ResponseEntity.accepted().body(candidatDto);
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error("Candidat not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while editing candidat: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CandidatDto> deleteCandidat(@PathVariable Long id) {
        try {
            CandidatDto etudiantDto = candidatService.deleteCandidat(id);
            return ResponseEntity.ok(etudiantDto);
        } catch (EntityNotFoundException e) {
            logger.error("Candidat not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while deleting candidat: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<CandidatDto> deleteCandidatsAll() {
        try {
            CandidatDto etudiantDto = candidatService.deleteAllCandidats();
            return ResponseEntity.ok(etudiantDto);
        } catch (EntityNotFoundException e) {
            logger.error("Error while deleting all candidats: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while deleting all candidats: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/new-candidat")
    public CandidatDto newEtudiant(@RequestBody CandidatDto candidatDto) {
        try {
            return candidatService.addCandidat(candidatDto);
        } catch (Exception e) {
            logger.error("Error while adding new candidat: {}", e.getMessage());
            return null;
        }
    }
}