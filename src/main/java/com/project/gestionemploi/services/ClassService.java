package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.ClassDTO;

public interface ClassService {
    List<ClassDTO> getAllClasses();

    ClassDTO getClassById(Long id);

    ClassDTO createClass(ClassDTO classDTO);

    ClassDTO updateClass(Long id, ClassDTO classDTO);

    void deleteClass(Long id);
}
