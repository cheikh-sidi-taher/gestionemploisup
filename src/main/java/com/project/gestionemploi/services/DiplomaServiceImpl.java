package com.project.gestionemploi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.DiplomaRepository;
import com.project.gestionemploi.dto.DiplomaDTO;

import java.util.List;
import java.util.stream.Collectors;
import com.project.gestionemploi.models.Diploma;

@Service
public class DiplomaServiceImpl implements DiplomaService {

    @Autowired
    private DiplomaRepository diplomaRepository;

    @Override
    public List<DiplomaDTO> getAllDiplomas() {
        List<Diploma> diplomas = diplomaRepository.findAll();
        return diplomas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public DiplomaDTO getDiplomaById(Long id) {
        Diploma diplomaEntity = diplomaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diploma not found with id: " + id));
        return convertToDTO(diplomaEntity);
    }

    @Override
    public DiplomaDTO createDiploma(DiplomaDTO diplomaDTO) {
        Diploma newDiploma = new Diploma();
        newDiploma.setName(diplomaDTO.getName());
       
        Diploma savedDiploma = diplomaRepository.save(newDiploma);
        return convertToDTO(savedDiploma);
    }

    @Override
    public DiplomaDTO updateDiploma(Long id, DiplomaDTO diplomaDTO) {
        Diploma existingDiploma = diplomaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diploma not found with id: " + id));

        existingDiploma.setName(diplomaDTO.getName());
       
        

        Diploma updatedDiploma = diplomaRepository.save(existingDiploma);
        return convertToDTO(updatedDiploma);
    }

    @Override
    public void deleteDiploma(Long id) {
        diplomaRepository.deleteById(id);
    }

    private DiplomaDTO convertToDTO(Diploma diplomaEntity) {
        DiplomaDTO diplomaDTO = new DiplomaDTO();
        diplomaDTO.setId(diplomaEntity.getId());
        diplomaDTO.setName(diplomaEntity.getName());
       
        return diplomaDTO;
    }
}

