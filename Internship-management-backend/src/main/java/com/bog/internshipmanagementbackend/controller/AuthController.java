package com.bog.internshipmanagementbackend.controller;

import com.bog.internshipmanagementbackend.domain.*;
import com.bog.internshipmanagementbackend.dto.AdminDto;
import com.bog.internshipmanagementbackend.exception.TokenRefreshException;
import com.bog.internshipmanagementbackend.payload.request.LoginRequest;
import com.bog.internshipmanagementbackend.payload.request.SignupRequest;
import com.bog.internshipmanagementbackend.payload.request.TokenRefreshRequest;
import com.bog.internshipmanagementbackend.payload.response.JwtResponse;
import com.bog.internshipmanagementbackend.payload.response.MessageResponse;
import com.bog.internshipmanagementbackend.payload.response.TokenRefreshResponse;
import com.bog.internshipmanagementbackend.repository.*;
import com.bog.internshipmanagementbackend.security.jwt.JwtUtils;
import com.bog.internshipmanagementbackend.service.impl.RefreshTokenServiceImpl;
import com.bog.internshipmanagementbackend.service.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CandidatRepository candidatRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    ProfesseurRepository professeurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        ERole eRole = ERole.valueOf(loginRequest.getRole());
        switch (eRole) {
            case ROLE_ADMIN:
                return authenticateAdmin(loginRequest);
            case ROLE_PROFESSOR:
                return authenticateProfesseur(loginRequest);
            case ROLE_ETUDIANT:
                return authenticateEtudiant(loginRequest);
            case ROLE_CANDIDAT:
                return authenticateCandidat(loginRequest);
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }
    }
    //    @PostMapping("/sign-in")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        String jwt = jwtUtils.generateJwtToken(userDetails);
//        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
//        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
//        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
//    }
    public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createAdminRefreshToken(userDetails.getId());
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//        ResponseCookie jwtRefreshCookie = jwtUtils.generateRefreshJwtCookie(refreshToken.getToken());
//        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new JwtResponse(
                        jwt,
                        refreshToken.getToken(),
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getAuthorities().iterator().next().getAuthority()));
    }

    public ResponseEntity<?> authenticateCandidat(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createAdminRefreshToken(userDetails.getId());
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new JwtResponse(
                        jwt,
                        refreshToken.getToken(),
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getAuthorities().iterator().next().getAuthority()));
    }
    public ResponseEntity<?> authenticateEtudiant(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createAdminRefreshToken(userDetails.getId());
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new JwtResponse(
                        jwt,
                        refreshToken.getToken(),
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getAuthorities().iterator().next().getAuthority()));
    }
    public ResponseEntity<?> authenticateProfesseur(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        RefreshToken refreshToken = refreshTokenService.createAdminRefreshToken(userDetails.getId());
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new JwtResponse(
                        jwt,
                        refreshToken.getToken(),
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getAuthorities().iterator().next().getAuthority()));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        ERole eRole = ERole.valueOf(request.getRole());
        switch (eRole) {
            case ROLE_ADMIN:
                return refreshAdminToken(request);
            case ROLE_PROFESSOR:
                return refreshProfesseurToken(request);
            case ROLE_ETUDIANT:
                return refreshEtudiantToken(request);
            case ROLE_CANDIDAT:
                return refreshCandidatToken(request);
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }
    }
    public ResponseEntity<?> refreshAdminToken(@Valid @RequestBody TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getAdmin)
                .map(admin -> {
                    String token=jwtUtils.generateTokenFromUsername(admin.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, request.getRefreshToken()));
                })
                .orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(), "Error refreshing token"));
    }
    public ResponseEntity<?> refreshCandidatToken(@Valid @RequestBody TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getCandidat)
                .map(candidat -> {
                    String token=jwtUtils.generateTokenFromUsername(candidat.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, request.getRefreshToken()));
                })
                .orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(), "Error refreshing token"));
    }
    public ResponseEntity<?> refreshEtudiantToken(@Valid @RequestBody TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getEtudiant)
                .map(etudiant -> {
                    String token=jwtUtils.generateTokenFromUsername(etudiant.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, request.getRefreshToken()));
                })
                .orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(), "Error refreshing token"));
    }
    public ResponseEntity<?> refreshProfesseurToken(@Valid @RequestBody TokenRefreshRequest request) {
        return refreshTokenService.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getProfesseur)
                .map(professeur -> {
                    String token=jwtUtils.generateTokenFromUsername(professeur.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, request.getRefreshToken()));
                })
                .orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(), "Error refreshing token"));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        ERole eRole = ERole.valueOf(signUpRequest.getRole());
        switch (eRole) {
            case ROLE_ADMIN:
                return registerAdmin(signUpRequest);
            case ROLE_PROFESSOR:
                return registerProfesseur(signUpRequest);
            case ROLE_ETUDIANT:
                return registerEtudiant(signUpRequest);
            case ROLE_CANDIDAT:
                return registerCandidat(signUpRequest);
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }
    }
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
        if (adminRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (adminRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new admin account
        Admin admin = new Admin(signUpRequest.getNom(), signUpRequest.getPrenom(), signUpRequest.getNumPerso(),
                signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        Role existingAdminRole = roleRepository.findByNom(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Admin role not found in the database"));
        // Assign the fixed role for admin
        admin.setRole(existingAdminRole);
        adminRepository.save(admin);
        // Create refresh token for the registered admin
        refreshTokenService.createAdminRefreshToken(admin.getId());
        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
    }
    public ResponseEntity<?> registerCandidat(@Valid @RequestBody SignupRequest signUpRequest) {
        if (candidatRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (candidatRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new candidat account
        Candidat candidat = new Candidat(signUpRequest.getNom(), signUpRequest.getPrenom(), signUpRequest.getNumPerso(),
                signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for candidat
        Role existingCandidatRole = roleRepository.findByNom(ERole.ROLE_CANDIDAT).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        candidat.setRole(existingCandidatRole);
        candidatRepository.save(candidat);
        // Create refresh token for the registered candidat
        refreshTokenService.createCandidatRefreshToken(candidat.getId());
        return ResponseEntity.ok(new MessageResponse("Candidat registered successfully!"));
    }
    public ResponseEntity<?> registerEtudiant(@Valid @RequestBody SignupRequest signUpRequest) {
        if (etudiantRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (etudiantRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new etudiant account
        Etudiant etudiant = new Etudiant(signUpRequest.getNom(), signUpRequest.getPrenom(), signUpRequest.getNumPerso(),
                signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for etudiant
        Role existingEtudiantRole = roleRepository.findByNom(ERole.ROLE_ETUDIANT).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        etudiant.setRole(existingEtudiantRole);
        etudiantRepository.save(etudiant);
        // Create refresh token for the registered etudiant
        refreshTokenService.createEtudiantRefreshToken(etudiant.getId());
        return ResponseEntity.ok(new MessageResponse("Etudiant registered successfully!"));
    }
    public ResponseEntity<?> registerProfesseur(@Valid @RequestBody SignupRequest signUpRequest) {
        if (professeurRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (professeurRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new professeur account
        Professeur professeur = new Professeur(signUpRequest.getNom(), signUpRequest.getPrenom(),
                signUpRequest.getUsername(), signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for professeur
        Role existingProfesseurRole = roleRepository.findByNom(ERole.ROLE_PROFESSOR).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        professeur.setRole(existingProfesseurRole);
        professeurRepository.save(professeur);
        // Create refresh token for the registered professeur
        refreshTokenService.createProfesseurRefreshToken(professeur.getId());
        return ResponseEntity.ok(new MessageResponse("Professeur registered successfully!"));
    }

    @PostMapping("/sign-out")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(new MessageResponse("You've been signed out!"));
    }
}
