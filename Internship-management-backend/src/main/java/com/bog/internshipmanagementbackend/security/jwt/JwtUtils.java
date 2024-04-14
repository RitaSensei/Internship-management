package com.bog.internshipmanagementbackend.security.jwt;
/*
This class is responsible for handling JWT (JSON Web Token) generation, validation, and
cookie management in a Spring Security context.
 */
import com.bog.internshipmanagementbackend.service.impl.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${internship-management.jwtSecret}")
    private String jwtSecret;

    @Value("${internship-management.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${internship-management.jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateJwtToken(userPrincipal);
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt)
                .path("/api")
                .maxAge(24 * 60 * 60)
                .httpOnly(true)
                .build();
        return cookie;
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null)
                .path("/api")
                .build();
        return cookie;
    }

    public JwtUser getUserNameFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build()
                .parseClaimsJws(token).getBody();

        String username = claims.getSubject();
        String userType = claims.get("userType", String.class);

        return new JwtUser(username, userType);
    }

    public String generateJwtToken(UserDetailsImpl userPrincipal) {
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public boolean isAdminToken(String authToken) {
        JwtUser jwtUser = getUserNameFromJwtToken(authToken);
        return "ADMIN".equals(jwtUser.getUserType());
    }

    public boolean isCandidatToken(String authToken) {
        JwtUser jwtUser = getUserNameFromJwtToken(authToken);
        return "CANDIDAT".equals(jwtUser.getUserType());
    }

    public boolean isEtudiantToken(String authToken) {
        JwtUser jwtUser = getUserNameFromJwtToken(authToken);
        return "ETUDIANT".equals(jwtUser.getUserType());
    }

    public boolean isProfesseurToken(String authToken) {
        JwtUser jwtUser = getUserNameFromJwtToken(authToken);
        return "PROFESSEUR".equals(jwtUser.getUserType());
    }
}
