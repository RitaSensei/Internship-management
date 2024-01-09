package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.*;
import com.bog.internshipmanagementbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Transactional
    public UserDetails loadAdminByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin Not Found with username: " + username));
        return UserDetailsImpl.build(admin);
    }

    @Transactional
    public UserDetails loadCandidatByUsername(String username) throws UsernameNotFoundException {
        Candidat candidat = candidatRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Candidat Not Found with username: " + username));
        return UserDetailsImpl.build(candidat);
    }

    @Transactional
    public UserDetails loadEtudiantByUsername(String username) throws UsernameNotFoundException {
        Etudiant etudiant = etudiantRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Etudiant Not Found with username: " + username));
        return UserDetailsImpl.build(etudiant);
    }

    @Transactional
    public UserDetails loadProfesseurByUsername(String username) throws UsernameNotFoundException {
        Professeur professeur = professeurRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Professeur Not Found with username: " + username));
        return UserDetailsImpl.build(professeur);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (adminRepository.existsByUsername(username)) {
            return loadAdminByUsername(username);
        } else if (candidatRepository.existsByUsername(username)) {
            return loadCandidatByUsername(username);
        } else if (etudiantRepository.existsByUsername(username)) {
            return loadEtudiantByUsername(username);
        } else if (professeurRepository.existsByUsername(username)) {
            return loadProfesseurByUsername(username);
        } else {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }
}
