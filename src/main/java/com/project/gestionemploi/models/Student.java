package com.project.gestionemploi.models;

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

@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String matricule;
    @Column(nullable = true)
    private String name;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = true)
    private String Nbac;

    @Column(nullable = true)
    private String NNI;

    @Column(nullable = true)
    private long tel;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    private Parent parentId;

    @OneToOne
    @JoinColumn(name = "diploma_id", nullable = true)
    private Diploma diplomaId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = true)
    private Class classId;


    public void removeParent() {
        this.parentId = null;
    }


    
}
