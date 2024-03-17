package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.DiplomaDTO;

public interface DiplomaService {
    List<DiplomaDTO> getAllDiplomas();

    DiplomaDTO getDiplomaById(Long id);

    DiplomaDTO createDiploma(DiplomaDTO diplomaDTO);

    DiplomaDTO updateDiploma(Long id, DiplomaDTO diplomaDTO);

    void deleteDiploma(Long id);
}
