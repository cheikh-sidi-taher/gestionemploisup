package com.project.gestionemploi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.gestionemploi.dto.DiplomaDTO;
import com.project.gestionemploi.services.DiplomaService;

import java.util.List;

@Controller
@RequestMapping("/diplomas")
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @GetMapping()
    public String getAllDiplomas(Model model) {
        List<DiplomaDTO> diplomas = diplomaService.getAllDiplomas();
        model.addAttribute("diplomas", diplomas);
        return "diploma/list";
    }

    @GetMapping("/{id}")
    public String getDiplomaById(@PathVariable Long id, Model model) {
        DiplomaDTO diplomaDTO = diplomaService.getDiplomaById(id);
        model.addAttribute("diploma", diplomaDTO);
        return "diploma/view";
    }

    @GetMapping("/create")
    public String createDiplomaForm(Model model) {
        model.addAttribute("diploma", new DiplomaDTO());
        return "diploma/create";
    }

    @PostMapping("/create")
    public String createDiploma(@ModelAttribute DiplomaDTO diplomaDTO) {
        diplomaService.createDiploma(diplomaDTO);
        return "redirect:/diplomas";
    }

    @GetMapping("/update/{id}")
    public String updateDiplomaForm(@PathVariable Long id, Model model) {
        DiplomaDTO diplomaDTO = diplomaService.getDiplomaById(id);
        model.addAttribute("diploma", diplomaDTO);
        return "diploma/update";
    }

    @PostMapping("/update/{id}")
    public String updateDiploma(@PathVariable Long id, @ModelAttribute DiplomaDTO diplomaDTO) {
        diplomaService.updateDiploma(id, diplomaDTO);
        return "redirect:/Diplomas";
    }

    @GetMapping("/delete/{id}")
    public String deleteDiploma(@PathVariable Long id) {
        diplomaService.deleteDiploma(id);
        return "redirect:/diplomas";
    }

}
