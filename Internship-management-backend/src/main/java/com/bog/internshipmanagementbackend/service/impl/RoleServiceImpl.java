package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.ERole;
import com.bog.internshipmanagementbackend.domain.Role;
import com.bog.internshipmanagementbackend.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {
  /*  @Autowired
    private RoleRepository roleRepository;

    // This method is just an example. You can call it in a suitable place in your application.
    @PostConstruct
    public void init() {
        // Check if roles are already populated
        if (roleRepository.count() == 0) {
            // Create roles if not exists
            createRoleIfNotExists(ERole.ROLE_ADMIN);
            createRoleIfNotExists(ERole.ROLE_PROFESSOR);
            createRoleIfNotExists(ERole.ROLE_ETUDIANT);
            createRoleIfNotExists(ERole.ROLE_CANDIDAT);
        }
    }

    private void createRoleIfNotExists(ERole nom) {
        roleRepository.findByNom(nom)
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setNom(nom);
                    return roleRepository.save(role);
                });
    }*/
}
