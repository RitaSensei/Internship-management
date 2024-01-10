package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.File;
import com.bog.internshipmanagementbackend.repository.FileRepository;
import com.bog.internshipmanagementbackend.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.UrlResource;
import java.net.MalformedURLException;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileRepository fileRepository;
    private final Path root = Paths.get("./Internship-management-backend/src/main/resources/uploads");

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    @Transactional
    public void store(MultipartFile file) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileUrl = "http://localhost:8080/api/files/" + fileName;
            String fileExtension = getFileExtension(Objects.requireNonNull(file.getContentType()));
            File fileToSave = new File(fileName, fileExtension, fileUrl);
            fileRepository.save(fileToSave);
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    private String getFileExtension(String contentType) {
        String[] parts = contentType.split("/");
        if (parts.length == 2) {
            return parts[1];
        }
        return "";
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(String filename) {
        try {
            Optional<File> fileOptional = fileRepository.findByName(filename);
            if(fileOptional.isPresent()) {
                Path file = root.resolve(filename);
                boolean deletedFromFileSystem = Files.deleteIfExists(file);
                if(deletedFromFileSystem) {
                    fileRepository.delete(fileOptional.get());
                    return true;
                } else {
                    throw new RuntimeException("Error deleting the file from local storage.");
                }
            } else {
                throw new RuntimeException("File not found in the database.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        try {
            List<File> fileEntities = fileRepository.findAll();
            for (File file:fileEntities) {
                Path filePath=root.resolve(file.getName());
                Files.deleteIfExists(filePath);
            }
            fileRepository.deleteAll();
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
