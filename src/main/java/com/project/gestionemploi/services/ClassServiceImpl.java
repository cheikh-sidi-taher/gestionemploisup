package com.project.gestionemploi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.ClassRepository;
import com.project.gestionemploi.dto.ClassDTO;

import java.util.List;
import java.util.stream.Collectors;
import com.project.gestionemploi.models.Class;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassDTO> getAllClasses() {
        List<Class> classes = classRepository.findAll();
        return classes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ClassDTO getClassById(Long id) {
        Class classEntity = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + id));
        return convertToDTO(classEntity);
    }

    @Override
    public ClassDTO createClass(ClassDTO classDTO) {
        Class newClass = new Class();
        newClass.setName(classDTO.getName());
        Class savedClass = classRepository.save(newClass);
        return convertToDTO(savedClass);
    }

    @Override
    public ClassDTO updateClass(Long id, ClassDTO classDTO) {
        Class existingClass = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + id));

        existingClass.setName(classDTO.getName());

        Class updatedClass = classRepository.save(existingClass);
        return convertToDTO(updatedClass);
    }

    @Override
    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    private ClassDTO convertToDTO(Class classEntity) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setId(classEntity.getId());
        classDTO.setName(classEntity.getName());
        return classDTO;
    }
}
