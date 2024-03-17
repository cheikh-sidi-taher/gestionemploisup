package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.ParentDTO;


public interface ParentService {
    List<ParentDTO> getAllParentes();

   
   
    ParentDTO getParentById(Long id);

    ParentDTO createParent(ParentDTO parentDTO);

    ParentDTO updateParent(Long id, ParentDTO parentDTO);

    void deleteParent(Long parentId);


    

   
    
}
