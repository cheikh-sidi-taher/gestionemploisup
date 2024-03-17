package com.project.gestionemploi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.gestionemploi.dto.TeacherDTO;
import com.project.gestionemploi.services.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String getAllTeacheres(Model model) {
        List<TeacherDTO> teachers = teacherService.getAllTeacheres();
        model.addAttribute("teachers", teachers);
        return "teacher/list";
    }

    @GetMapping("/{id}")
    public String getTeacherById(@PathVariable Long id, Model model) {
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacherDTO);
        return "teacher/view";
    }

    @GetMapping("/create")
    public String createTeacherForm(Model model) {
        model.addAttribute("teacher", new TeacherDTO());
        return "teacher/create";
    }

    @PostMapping("/create")
    public String createTeacher(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.createTeacher(teacherDTO);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String updateTeacherForm(@PathVariable Long id, Model model) {
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacherDTO);
        return "teacher/update";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute TeacherDTO teacherDTO) {
        teacherService.updateTeacher(id, teacherDTO);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }
}