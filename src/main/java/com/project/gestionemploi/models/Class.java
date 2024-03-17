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
@Table(name="classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @OneToOne(mappedBy = "classeId", cascade = CascadeType.ALL)
    private Session session;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL)
    private List<Student> students;
}
