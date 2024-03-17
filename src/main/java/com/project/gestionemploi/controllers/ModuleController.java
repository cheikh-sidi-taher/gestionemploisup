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

import com.project.gestionemploi.dto.ModuleDTO;
import com.project.gestionemploi.services.ModuleService;

@Controller
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public String getAllModules(Model model) {
        List<ModuleDTO> modules = moduleService.getAllModules();
        model.addAttribute("modules", modules);
        return "module/list";
    }

    @GetMapping("/{id}")
    public String getModuleById(@PathVariable Long id, Model model) {
        ModuleDTO moduleDTO = moduleService.getModuleById(id);
        model.addAttribute("module", moduleDTO);
        return "module/view";
    }

    @GetMapping("/create")
    public String createModuleForm(Model model) {
        model.addAttribute("module", new ModuleDTO());
        return "module/create";
    }

    @PostMapping("/create")
    public String createModule(@ModelAttribute ModuleDTO moduleDTO) {
        moduleService.createModule(moduleDTO);
        return "redirect:/modules";
    }

    @GetMapping("/update/{id}")
    public String updateModuleForm(@PathVariable Long id, Model model) {
        ModuleDTO moduleDTO = moduleService.getModuleById(id);
        model.addAttribute("module", moduleDTO);
        return "module/update";
    }

    @PostMapping("/update/{id}")
    public String updateModule(@PathVariable Long id, @ModelAttribute ModuleDTO moduleDTO) {
        moduleService.updateModule(id, moduleDTO);
        return "redirect:/modules";
    }

    @GetMapping("/delete/{id}")
    public String deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return "redirect:/modules";
    }
}
