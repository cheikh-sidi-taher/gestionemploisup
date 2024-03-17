// StudentServiceImpl.java
package com.project.gestionemploi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.models.Student;
import com.project.gestionemploi.Repository.StudentRepository;
import com.project.gestionemploi.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return convertToDTO(studentEntity);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student newStudent = new Student();
        newStudent.setMatricule(studentDTO.getMatricule());
        newStudent.setName(studentDTO.getName());
        newStudent.setFirstName(studentDTO.getFirstName());
        newStudent.setGender(studentDTO.getGender());
        newStudent.setNbac(studentDTO.getNbac());
        newStudent.setNNI(studentDTO.getNNI());
        newStudent.setTel(studentDTO.getTel());
        newStudent.setParentId(studentDTO.getParentId());
        newStudent.setClassId(studentDTO.getClassId());
        newStudent.setDiplomaId(studentDTO.getDiplomaId());

        Student savedStudent = studentRepository.save(newStudent);
        return convertToDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update existing fields
        existingStudent.setMatricule(studentDTO.getMatricule());
        existingStudent.setName(studentDTO.getName());
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setGender(studentDTO.getGender());
        existingStudent.setNbac(studentDTO.getNbac());
        existingStudent.setNNI(studentDTO.getNNI());
        existingStudent.setTel(studentDTO.getTel());
        existingStudent.setParentId(studentDTO.getParentId());
        existingStudent.setClassId(studentDTO.getClassId());
        existingStudent.setDiplomaId(studentDTO.getDiplomaId());

        Student updatedStudent = studentRepository.save(existingStudent);
        return convertToDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    

    private StudentDTO convertToDTO(Student studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setMatricule(studentEntity.getMatricule());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setGender(studentEntity.getGender());
        studentDTO.setNbac(studentEntity.getNbac());
        studentDTO.setNNI(studentEntity.getNNI());
        studentDTO.setTel(studentEntity.getTel());
        studentDTO.setParentId(studentEntity.getParentId());
        studentDTO.setClassId(studentEntity.getClassId());
        studentDTO.setDiplomaId(studentEntity.getDiplomaId());

        return studentDTO;
    }
}
