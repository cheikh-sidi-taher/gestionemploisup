package com.project.gestionemploi.models;

import java.time.LocalTime;
import java.util.Date;

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

@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = true)
    private LocalTime startTime;
    @Column(nullable = true)
    private LocalTime endTime;
    @Column(nullable = true)
    private String type;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = true)
    private Module moduleId;

    @OneToOne
    @JoinColumn(name = "class_id", nullable = true)
    private Class classeId;
}
