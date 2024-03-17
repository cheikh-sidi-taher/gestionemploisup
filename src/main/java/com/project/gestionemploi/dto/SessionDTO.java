package com.project.gestionemploi.dto;

import java.time.LocalTime;


import com.project.gestionemploi.models.Teacher;
import com.project.gestionemploi.models.Class;
import com.project.gestionemploi.models.Module;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SessionDTO {

    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String type;
    private Module moduleId;
    private Teacher teacherId;
    private Class classeId;

}
