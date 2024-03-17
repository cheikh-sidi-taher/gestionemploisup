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

import com.project.gestionemploi.dto.ParentDTO;

import com.project.gestionemploi.services.ParentService;

@Controller
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public String getAllParentes(Model model) {
        List<ParentDTO> parents = parentService.getAllParentes();
        model.addAttribute("parents", parents);
        return "parent/list";
    }

    @GetMapping("/{id}")
    public String getParentById(@PathVariable Long id, Model model) {
        ParentDTO parentDTO = parentService.getParentById(id);
        model.addAttribute("parent", parentDTO);
        return "parent/view";
    }

    @GetMapping("/create")
    public String createParentForm(Model model) {
        model.addAttribute("parent", new ParentDTO());
        return "parent/create";
    }

    @PostMapping("/create")
    public String createParent(@ModelAttribute ParentDTO parentDTO) {
        parentService.createParent(parentDTO);
        return "redirect:/parents";
    }

    @GetMapping("/update/{id}")
    public String updateParentForm(@PathVariable Long id, Model model) {
        ParentDTO parentDTO = parentService.getParentById(id);
        model.addAttribute("parent", parentDTO);
        return "parent/update";
    }

    @PostMapping("/update/{id}")
    public String updateParent(@PathVariable Long id, @ModelAttribute ParentDTO parentDTO) {
        parentService.updateParent(id, parentDTO);
        return "redirect:/parents";
    }

    @GetMapping("/delete/{id}")
    public String deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
        return "redirect:/parents";
    }

}
