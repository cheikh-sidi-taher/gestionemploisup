package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.TeacherDTO;

public interface TeacherService {
    List<TeacherDTO> getAllTeacheres();
    TeacherDTO getTeacherById(Long id);
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO);
    void deleteTeacher(Long id);
}
