package com.bog.internshipmanagementbackend;

import com.bog.internshipmanagementbackend.service.AdminService;
import com.bog.internshipmanagementbackend.service.FileStorageService;
import com.bog.internshipmanagementbackend.service.impl.AdminServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InternshipManagementBackendApplication implements CommandLineRunner {
	@Resource
	FileStorageService fileStorageService;

	@Resource
	AdminServiceImpl adminService;

	public static void main(String[] args) {
		SpringApplication.run(InternshipManagementBackendApplication.class, args);
	}
	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		fileStorageService.init();
//		adminService.addAdminForTesting();
	}
}
