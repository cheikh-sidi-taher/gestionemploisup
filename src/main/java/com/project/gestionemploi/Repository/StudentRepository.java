package com.project.gestionemploi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gestionemploi.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  
   
}

