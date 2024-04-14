package com.bog.internshipmanagementbackend.service;

import com.bog.internshipmanagementbackend.dto.CandidatDto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

public interface CandidatService {
    CandidatDto addCandidat(CandidatDto CandidatDto);
    CandidatDto findCandidatById(long id);
    CandidatDto findByEmailAndNumPerso(String email, String numPerso);
    List<CandidatDto> findAllCandidats();
    CandidatDto updateCandidat(CandidatDto CandidatDto, long id) throws EntityNotFoundException;
    CandidatDto deleteCandidat(long id);
    CandidatDto deleteAllCandidats();
}
