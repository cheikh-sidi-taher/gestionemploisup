package com.project.gestionemploi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gestionemploi.dto.ClassDTO;
import com.project.gestionemploi.services.ClassService;



@Controller
public class PageController {

   
     @GetMapping("/dashboards")
    public String Page(){
       
        return "dashboards/dashboard";
    }


    //  @GetMapping("/registers")
    // public String RegistrationForm(){
    
    //     return "registers/register";
    // }
}
