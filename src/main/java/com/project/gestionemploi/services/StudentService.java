package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.StudentDTO;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

   

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

   

    void deleteStudent(Long id);


    


   
}
