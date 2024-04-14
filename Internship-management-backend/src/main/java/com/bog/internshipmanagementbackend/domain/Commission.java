package com.bog.internshipmanagementbackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private Long numCandidat;
    @Column(nullable = false)
    private String avis;

    @OneToMany(mappedBy = "commission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examine> candidats;
}
