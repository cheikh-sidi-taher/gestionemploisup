package com.project.gestionemploi.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;
    @Column(name = "NiveauModule", nullable = true)
    private String niveau;
    @Column(name = "SemestreModule", nullable = true)
    private String semestre;

    @OneToMany(mappedBy = "moduleId", cascade = CascadeType.ALL)
    private List<Session> sessions = new ArrayList<>();
}
