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

@Table(name = "parents")

public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private long tel;

    @OneToMany(mappedBy = "parentId",cascade = CascadeType.ALL)
    private List<Student> students;

}
