package com.bog.internshipmanagementbackend.controller;

import com.bog.internshipmanagementbackend.dto.AdminDto;
import com.bog.internshipmanagementbackend.repository.AdminRepository;
import com.bog.internshipmanagementbackend.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("Admin")
public class AdminController {
}
