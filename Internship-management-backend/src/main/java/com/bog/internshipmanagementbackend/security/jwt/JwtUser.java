package com.bog.internshipmanagementbackend.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtUser {
    private String username;
    private String userType;

}
