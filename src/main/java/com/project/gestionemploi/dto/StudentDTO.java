package com.project.gestionemploi.dto;
import com.project.gestionemploi.models.Diploma;
import com.project.gestionemploi.models.Parent;
import com.project.gestionemploi.models.Class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String matricule;
    private String name;
    private String firstName;
    private String gender;
    private String Nbac;
    private String NNI;
    private long tel;
    private Parent parentId;
    private Diploma diplomaId;
    private Class classId;

    
}
