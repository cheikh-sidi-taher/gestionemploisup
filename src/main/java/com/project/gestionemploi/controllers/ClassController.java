package com.project.gestionemploi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.gestionemploi.dto.ClassDTO;
import com.project.gestionemploi.services.ClassService;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping()
    public String getAllClasses(Model model) {
        List<ClassDTO> classes = classService.getAllClasses();
        model.addAttribute("classes", classes);
        return "class/list";
    }

    @GetMapping("/{id}")
    public String getClassById(@PathVariable Long id, Model model) {
        ClassDTO classDTO = classService.getClassById(id);
        model.addAttribute("class", classDTO);
        return "class/view";
    }

    @GetMapping("/create")
    public String createClassForm(Model model) {
        model.addAttribute("class", new ClassDTO());
        return "class/create";
    }

    @PostMapping("/create")
    public String createClass(@ModelAttribute ClassDTO classDTO) {
        classService.createClass(classDTO);
        return "redirect:/classes";
    }

    @GetMapping("/update/{id}")
    public String updateClassForm(@PathVariable Long id, Model model) {
        ClassDTO classDTO = classService.getClassById(id);
        model.addAttribute("class", classDTO);
        return "class/update";
    }

    @PostMapping("/update/{id}")
    public String updateClass(@PathVariable Long id, @ModelAttribute ClassDTO classDTO) {
        classService.updateClass(id, classDTO);
        return "redirect:/classes";
    }

    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "redirect:/classes";
    }

   

}
