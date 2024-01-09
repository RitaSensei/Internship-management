package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,String> {
}
