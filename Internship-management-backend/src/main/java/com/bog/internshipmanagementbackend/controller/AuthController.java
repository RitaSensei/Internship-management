package com.bog.internshipmanagementbackend.controller;

import com.bog.internshipmanagementbackend.domain.*;
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
//    UserRepositoryBase<User> userRepository;

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
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/sign-in-admin")
    public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createAdminRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/sign-in-candidat")
    public ResponseEntity<?> authenticateCandidat(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createCandidatRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }
    @PostMapping("/sign-in-etudiant")
    public ResponseEntity<?> authenticateEtudiant(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createEtudiantRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }
    @PostMapping("/sign-in-professeur")
    public ResponseEntity<?> authenticateProfesseur(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createProfesseurRefreshToken(userDetails.getId());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/refresh-token-admin")
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
    @PostMapping("/refresh-token-candidat")
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
    @PostMapping("/refresh-token-etudiant")
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
    @PostMapping("/refresh-token-professeur")
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
    @PostMapping("/sign-up-admin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
        if (adminRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (adminRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new admin account
        Admin admin = new Admin(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for admin
        Role adminRole = roleRepository.findByNom(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        admin.setRoles(Collections.singleton(adminRole));
        adminRepository.save(admin);
        // Create refresh token for the registered admin
        refreshTokenService.createAdminRefreshToken(admin.getId());
        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
    }
    @PostMapping("/sign-up-candidat")
    public ResponseEntity<?> registerCandidat(@Valid @RequestBody SignupRequest signUpRequest) {
        if (candidatRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (candidatRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new candidat account
        Candidat candidat = new Candidat(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for candidat
        Role candidatRole = roleRepository.findByNom(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        candidat.setRoles(Collections.singleton(candidatRole));
        candidatRepository.save(candidat);
        // Create refresh token for the registered candidat
        refreshTokenService.createCandidatRefreshToken(candidat.getId());
        return ResponseEntity.ok(new MessageResponse("Candidat registered successfully!"));
    }
    @PostMapping("/sign-up-etudiant")
    public ResponseEntity<?> registerEtudiant(@Valid @RequestBody SignupRequest signUpRequest) {
        if (etudiantRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (etudiantRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new etudiant account
        Etudiant etudiant = new Etudiant(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for etudiant
        Role etudiantRole = roleRepository.findByNom(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        etudiant.setRoles(Collections.singleton(etudiantRole));
        etudiantRepository.save(etudiant);
        // Create refresh token for the registered etudiant
        refreshTokenService.createEtudiantRefreshToken(etudiant.getId());
        return ResponseEntity.ok(new MessageResponse("Etudiant registered successfully!"));
    }
    @PostMapping("/sign-up-professeur")
    public ResponseEntity<?> registerProfesseur(@Valid @RequestBody SignupRequest signUpRequest) {
        if (professeurRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        if (professeurRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new professeur account
        Professeur professeur = new Professeur(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        // Assign the fixed role for professeur
        Role professeurRole = roleRepository.findByNom(ERole.ROLE_PROFESSOR).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        professeur.setRoles(Collections.singleton(professeurRole));
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
