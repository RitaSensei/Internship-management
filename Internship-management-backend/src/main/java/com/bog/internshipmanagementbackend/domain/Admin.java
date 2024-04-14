package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data @NoArgsConstructor
public class Admin extends User{

    @Column(nullable = false, unique = true)
    private String numPerso;

    public Admin(String username, String email, String password) {
        super(username, email, password);
    }

    public Admin(String nom, String prenom, String numPerso, String username, String email, String password) {
        super(nom,prenom,username, email, password);
        this.numPerso=numPerso;
    }
}
