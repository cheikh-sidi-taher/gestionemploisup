package com.project.gestionemploi.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    void deleteById(Parent parentId);

    
   
}
