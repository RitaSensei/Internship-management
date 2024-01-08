package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.Admin;
import com.bog.internshipmanagementbackend.dto.AdminDto;
import com.bog.internshipmanagementbackend.repository.AdminRepository;
import com.bog.internshipmanagementbackend.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private AdminRepository AdminRepository;
    private ModelMapper Mapper;

    @Override
    public AdminDto addAdmin(AdminDto AdminDto) {
        Admin Admin = Mapper.map(AdminDto,Admin.class);
        Admin savedAdmin = AdminRepository.save(Admin);
        return Mapper.map(savedAdmin, AdminDto.class);
    }

    @Override
    public AdminDto findAdminById(int id) {
        Admin Admin = AdminRepository.findById((long) id).orElse(null);
        return Mapper.map(Admin,AdminDto.class);
    }

    @Override
    public List<AdminDto> findAllAdmins() {
        List<Admin> Admins = AdminRepository.findAll();
        List<AdminDto> AdminsDTOs = Admins
                .stream()
                .map(Admin -> Mapper.map(Admin, AdminDto.class))
                .collect(Collectors.toList());
        return AdminsDTOs;
    }

    @Override
    public AdminDto updateAdmin(AdminDto AdminDto, int id) throws EntityNotFoundException {
        Admin Admin = Mapper.map(AdminDto,Admin.class);
        Admin save = AdminRepository.save(Admin);
        return Mapper.map(save,AdminDto.class);
    }

    @Override
    public void deleteAdmin(int id) {
        AdminRepository.deleteById((long) id);
    }

    @Override
    public void deleteAllAdmins() {
        AdminRepository.deleteAll();

    }

    public AdminDto findByEmail(String email) {
        Admin Admin = AdminRepository.findByEmail(email);
        return Mapper.map(Admin, AdminDto.class);
    }

    public AdminDto findByNumPerso(String numPerso) {
        Admin Admin = AdminRepository.findByNumPerso(numPerso);
        return Mapper.map(Admin, AdminDto.class);
    }

    public AdminDto findByEmailAndNumPerso(String email, String numPerso) {
        Admin Admin = AdminRepository.findByEmailAndNumPerso(email, numPerso);
        return Mapper.map(Admin, AdminDto.class);
    }

    public AdminDto AdminLogin(String email, String password) {
        /*Admin Admin = AdminRepository.findByEmailAndPassword(email, password);
        return Mapper.map(Admin, AdminDto.class);*/
        return null;
    }

    @Override
    public List<AdminDto> findAdminsByRole(int annee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean Inscription() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AdminDto setAdminRole(String Role) {
        // TODO Auto-generated method stub
        return null;
    }
}
