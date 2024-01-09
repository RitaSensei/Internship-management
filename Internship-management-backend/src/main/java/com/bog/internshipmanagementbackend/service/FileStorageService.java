package com.bog.internshipmanagementbackend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {
    void init();
    void store(MultipartFile file);
    Resource load(String fileName);
    public boolean delete(String filename);
    void deleteAll();
    Stream<Path> loadAll();
}
