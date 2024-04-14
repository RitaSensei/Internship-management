package com.bog.internshipmanagementbackend.service.impl;

import com.bog.internshipmanagementbackend.domain.*;
import com.bog.internshipmanagementbackend.exception.TokenRefreshException;
import com.bog.internshipmanagementbackend.repository.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl {
    @Value("${internship-management.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
//    public RefreshToken createRefreshToken(Long userId) {
//        RefreshToken refreshToken = new RefreshToken();
//        refreshToken.setUser(userRepository.findById(userId).get());
//        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
//        refreshToken.setToken(UUID.randomUUID().toString());
//        refreshToken = refreshTokenRepository.save(refreshToken);
//        return refreshToken;
//    }

    public RefreshToken createAdminRefreshToken(Long adminId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setAdmin(adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found")));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken createCandidatRefreshToken(Long candidatId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCandidat(candidatRepository.findById(candidatId).orElseThrow(() -> new RuntimeException("Candidat not found")));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }
    public RefreshToken createEtudiantRefreshToken(Long etudiantId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setEtudiant(etudiantRepository.findById(etudiantId).orElseThrow(() -> new RuntimeException("Etudiant not found")));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken createProfesseurRefreshToken(Long professeurId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setProfesseur(professeurRepository.findById(professeurId).orElseThrow(() -> new RuntimeException("Professeur not found")));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(@NotNull RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
    //    @Transactional
//    public int deleteByUserId(Long userId) {
//        User user= userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
//        return refreshTokenRepository.deleteByUser(user);
//    }
    @Transactional
    public int deleteAdminRefreshTokens(Long adminId) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));
        return refreshTokenRepository.deleteByAdmin(admin);
    }

    @Transactional
    public int deleteCandidatRefreshTokens(Long candidatId) {
        Candidat candidat = candidatRepository.findById(candidatId).orElseThrow(() -> new RuntimeException("Candidat not found"));
        return refreshTokenRepository.deleteByCandidat(candidat);
    }
    @Transactional
    public int deleteEtudiantRefreshTokens(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElseThrow(() -> new RuntimeException("Etudiant not found"));
        return refreshTokenRepository.deleteByEtudiant(etudiant);
    }

    @Transactional
    public int deleteProfesseurRefreshTokens(Long professeurId) {
        Professeur professeur = professeurRepository.findById(professeurId).orElseThrow(() -> new RuntimeException("Professeur not found"));
        return refreshTokenRepository.deleteByProfesseur(professeur);
    }
}
