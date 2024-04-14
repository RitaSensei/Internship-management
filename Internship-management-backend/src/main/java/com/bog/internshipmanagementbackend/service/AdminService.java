package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.AdminDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface AdminService {
    AdminDto addAdmin(AdminDto AdminDto);
    AdminDto findAdminById(int id);
    List<AdminDto> findAllAdmins();
    List<AdminDto> findAdminsByRole(int annee);
    AdminDto setAdminRole(String Role);
    AdminDto updateAdmin(AdminDto AdminDto, int id) throws EntityNotFoundException;
    void deleteAdmin(int id);
    void deleteAllAdmins();
//    AdminDto AdminLogin(String email, String password);
//    boolean Inscription();
}
