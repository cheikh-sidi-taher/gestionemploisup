package com.project.gestionemploi.models;
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

@Table(name="teachers")
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(name = "first_name", nullable = true)
    private String firstName;  // Utilisation de camelCase pour les noms de variables

    @Column(nullable = true)
    private String subject;

    @Column(nullable = true)
    private String diploma;

    @Column(name = "cv_file", nullable = true)
    private String cvFile;  // Utilisation de snake_case pour les noms de colonnes

    @Column(nullable = true)
    private Long tel;  

    @OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL)
    private List<Session> sessions;

   

}
