package com.bog.internshipmanagementbackend.controller;

import com.bog.internshipmanagementbackend.dto.EtudiantDto;
import com.bog.internshipmanagementbackend.service.EtudiantService;
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
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final Logger logger = LoggerFactory.getLogger(EtudiantController.class);

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/all")
    public List<EtudiantDto> getEtudiantsAll() {
        try {
            return etudiantService.findAllEtudiants();
        } catch (EntityNotFoundException e) {
            logger.error("Error while getting all etudiants: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDto> getEtudiant(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(etudiantService.findEtudiantById(id));
        } catch (EntityNotFoundException e) {
            logger.error("Etudiant not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EtudiantDto> editEtudiant(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto) {
        try {
            etudiantDto = etudiantService.updateEtudiant(etudiantDto, id);
            return ResponseEntity.accepted().body(etudiantDto);
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error("Etudiant not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while editing etudiant: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EtudiantDto> deleteEtudiant(@PathVariable Long id) {
        try {
            EtudiantDto etudiantDto = etudiantService.deleteEtudiant(id);
            return ResponseEntity.ok(etudiantDto);
        } catch (EntityNotFoundException e) {
            logger.error("Etudiant not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while deleting etudiant: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<EtudiantDto> deleteEtudiantsAll() {
        try {
            EtudiantDto etudiantDto = etudiantService.deleteAllEtudiants();
            return ResponseEntity.ok(etudiantDto);
        } catch (EntityNotFoundException e) {
            logger.error("Error while deleting all etudiants: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error while deleting all etudiants: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new-etudiant")
    public EtudiantDto newEtudiant(@RequestBody EtudiantDto etudiantDto) {
        try {
            return etudiantService.addEtudiant(etudiantDto);
        } catch (Exception e) {
            logger.error("Error while adding new etudiant: {}", e.getMessage());
            return null;
        }
    }
}