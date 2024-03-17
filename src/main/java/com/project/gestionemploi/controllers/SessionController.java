package com.project.gestionemploi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.gestionemploi.dto.SessionDTO;
import com.project.gestionemploi.models.Session;
import com.project.gestionemploi.services.ClassService;
import com.project.gestionemploi.services.ModuleService;
import com.project.gestionemploi.services.SessionService;
import com.project.gestionemploi.services.TeacherService;


@Controller
@RequestMapping("/sessions")
public class SessionController {
   

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassService classService;
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public String getAllSessions(Model model) {
        List<SessionDTO> sessions = sessionService.getAllSessions();
        model.addAttribute("sessions", sessions);
        return "session/list";
    }

    @GetMapping("/{id}")
    public String getSessionById(@PathVariable Long id, Model model) {
        SessionDTO sessionDTO = sessionService.getSessionById(id);
        model.addAttribute("session", sessionDTO);
        return "session/view";
    }

    @GetMapping("/create")
    public String createSessionForm(Model model) {
        model.addAttribute("session", new Session());
        model.addAttribute("teachers", teacherService.getAllTeacheres());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("modules", moduleService.getAllModules());

        return "session/create";
    }

    @PostMapping("/create")
    public String createSession(@ModelAttribute SessionDTO sessionDTO) {
        sessionService.createSession(sessionDTO);
        return "redirect:/sessions";
    }

    @GetMapping("/update/{id}")
    public String updateSessionForm(@PathVariable Long id, Model model) {
        SessionDTO sessionDTO = sessionService.getSessionById(id);
        model.addAttribute("Session", sessionDTO);
        model.addAttribute("teachars", teacherService.getAllTeacheres());
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("modules", moduleService.getAllModules());
        return "session/update";
    }

    @PostMapping("/update/{id}")
    public String updateSession(@PathVariable Long id, @ModelAttribute SessionDTO sessionDTO) {
        sessionService.updateSession(id, sessionDTO);
        return "redirect:/Sessions";
    }

    @GetMapping("/delete/{id}")
    public String deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return "redirect:/sessions";
    }
}
