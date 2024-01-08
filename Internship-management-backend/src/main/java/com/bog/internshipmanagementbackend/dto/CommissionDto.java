package com.bog.internshipmanagementbackend.dto;

import lombok.Data;

@Data
public class CommissionDto {
    private Long id;
    private int type;
    private Long numCandidat;
    private String avis;
}
