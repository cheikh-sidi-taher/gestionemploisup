package com.project.gestionemploi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.Diploma;

public interface DiplomaRepository extends JpaRepository<Diploma, Long> {

    void deleteById(Diploma diplomaId);

   
}

