package com.project.gestionemploi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    private Long id;

    private String name;

    private String firstName; 

    private String subject;

    private String diploma;

    private String cvFile;

    private Long tel;
}
