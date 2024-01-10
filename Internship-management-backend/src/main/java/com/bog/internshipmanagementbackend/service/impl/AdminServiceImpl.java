package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Admin;
import com.bog.internshipmanagementbackend.domain.ERole;
import com.bog.internshipmanagementbackend.domain.Role;
import com.bog.internshipmanagementbackend.dto.AdminDto;
import com.bog.internshipmanagementbackend.repository.AdminRepository;
import com.bog.internshipmanagementbackend.repository.RoleRepository;
import com.bog.internshipmanagementbackend.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper mapper;

    @Override
    public AdminDto addAdmin(AdminDto AdminDto) {
        Admin Admin = mapper.map(AdminDto,Admin.class);
        Admin savedAdmin = adminRepository.save(Admin);
        return mapper.map(savedAdmin, AdminDto.class);
    }

    @Override
    public AdminDto findAdminById(int id) {
        Admin Admin = adminRepository.findById((long) id).orElse(null);
        return mapper.map(Admin,AdminDto.class);
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        List<Admin> Admins = adminRepository.findAll();
        List<AdminDto> AdminsDTOs = Admins
                .stream()
                .map(Admin -> mapper.map(Admin, AdminDto.class))
                .collect(Collectors.toList());
        return AdminsDTOs;
    }

    @Override
    public AdminDto updateAdmin(AdminDto AdminDto, int id) throws EntityNotFoundException {
        Admin Admin = mapper.map(AdminDto,Admin.class);
        Admin save = adminRepository.save(Admin);
        return mapper.map(save,AdminDto.class);
    }

    @Override
    public void deleteAdmin(int id) {
        adminRepository.deleteById((long) id);
    }

    @Override
    public void deleteAllAdmins() {
        adminRepository.deleteAll();
    }

    public AdminDto findByEmail(String email) {
        Admin Admin = adminRepository.findByEmail(email);
        return mapper.map(Admin, AdminDto.class);
    }

    public AdminDto findByNumPerso(String numPerso) {
        Admin Admin = adminRepository.findByNumPerso(numPerso);
        return mapper.map(Admin, AdminDto.class);
    }

    public AdminDto findByEmailAndNumPerso(String email, String numPerso) {
        Admin Admin = adminRepository.findByEmailAndNumPerso(email, numPerso);
        return mapper.map(Admin, AdminDto.class);
    }

    @Override
    public List<AdminDto> findAdminsByRole(int annee) {
        // TODO Auto-generated method stub
        return null;
    }

    //    @Transactional
//    public AdminDto adminLogin(String email, String password){
//        try {
//            if (email != null && password != null)
//                adminRepository.findByEmailAndAndPassword(email, password);
//            return mapper.map(adminRepository.findByEmailAndAndPassword(email, password), AdminDto.class);
//        }catch (EntityNotFoundException e){
//            e.printStackTrace();
//            throw new EntityNotFoundException("credentials not found !");
//        }
//    }
    @Override
    public AdminDto setAdminRole(String Role) {
        // TODO Auto-generated method stub
        return null;
    }
    @Transactional
    public AdminDto addAdminForTesting() {
        AdminDto adminDto = new AdminDto();
        adminDto.setNom("TestAdmin");
        adminDto.setPrenom("Test");
        adminDto.setUsername("testadmin");
        adminDto.setEmail("testadmin@example.com");
        adminDto.setPassword(passwordEncoder.encode("password123"));
        adminDto.setNumPerso("1234567890");
//        Role adminRole = new Role();
//        adminRole.setNom(ERole.ROLE_ADMIN);
//        adminDto.setRole(adminRole);

        // Look up existing admin role from the database
        Role existingAdminRole = roleRepository.findByNom(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Admin role not found in the database"));

        // Set the existing admin role to the adminDto
        adminDto.setRole(existingAdminRole);


        return addAdmin(adminDto);
    }
}