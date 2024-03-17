package com.project.gestionemploi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

    
   
}
