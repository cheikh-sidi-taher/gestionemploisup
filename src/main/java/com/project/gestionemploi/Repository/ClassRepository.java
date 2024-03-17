package com.project.gestionemploi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.Class;


public interface ClassRepository extends JpaRepository<Class, Long> {

    void deleteById(Class classId);

 

    
}
