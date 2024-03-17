package com.project.gestionemploi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.TeacherRepository;
import com.project.gestionemploi.dto.TeacherDTO;
import com.project.gestionemploi.models.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService{
     @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAllTeacheres() {
        List<Teacher> teacheres = teacherRepository.findAll();
        return teacheres.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        Teacher teacherEntity = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return convertToDTO(teacherEntity);
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher newTeacher = new Teacher();
        
        newTeacher.setName(teacherDTO.getName());
        newTeacher.setTel(teacherDTO.getTel());
        newTeacher.setFirstName(teacherDTO.getFirstName());
        newTeacher.setDiploma(teacherDTO.getDiploma());
        newTeacher.setSubject(teacherDTO.getSubject());
        newTeacher.setCvFile(teacherDTO.getCvFile());
        Teacher savedTeacher = teacherRepository.save(newTeacher);
        return convertToDTO(savedTeacher);
    }

    @Override
    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        
        existingTeacher.setName(teacherDTO.getName());
        existingTeacher.setTel(teacherDTO.getTel());
        existingTeacher.setFirstName(teacherDTO.getFirstName());
        existingTeacher.setDiploma(teacherDTO.getDiploma());
        existingTeacher.setSubject(teacherDTO.getSubject());
        existingTeacher.setCvFile(teacherDTO.getCvFile());
        Teacher updatedTeacher = teacherRepository.save(existingTeacher);
        return convertToDTO(updatedTeacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    private TeacherDTO convertToDTO(Teacher teacherEntity) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacherEntity.getId());
        teacherDTO.setName(teacherEntity.getName());
        teacherDTO.setTel(teacherEntity.getTel());
        teacherDTO.setFirstName(teacherEntity.getFirstName());
        teacherDTO.setDiploma(teacherEntity.getDiploma());
        teacherDTO.setSubject(teacherEntity.getSubject());
        teacherDTO.setCvFile(teacherEntity.getCvFile());
        return teacherDTO;
    }


    
}
