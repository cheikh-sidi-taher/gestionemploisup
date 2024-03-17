package com.project.gestionemploi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.project.gestionemploi.dto.StudentDTO;
import com.project.gestionemploi.models.Student;
import com.project.gestionemploi.services.ClassService;
import com.project.gestionemploi.services.DiplomaService;
import com.project.gestionemploi.services.ParentService;
import com.project.gestionemploi.services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    private DiplomaService diplomaService;

    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        model.addAttribute("student", studentDTO);
        return "student/view";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("parents", parentService.getAllParentes());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("diplomas", diplomaService.getAllDiplomas());

        return "student/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute StudentDTO StudentDTO) {
        studentService.createStudent(StudentDTO);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        model.addAttribute("student", studentDTO);
        model.addAttribute("parents", parentService.getAllParentes());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("diplomas", diplomaService.getAllDiplomas());
        return "student/update";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
