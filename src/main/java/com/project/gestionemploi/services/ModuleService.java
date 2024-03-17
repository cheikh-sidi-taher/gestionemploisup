package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.ModuleDTO;

public interface ModuleService {
    ModuleDTO getModuleById(Long id);

    List<ModuleDTO> getAllModules();

    ModuleDTO createModule(ModuleDTO moduleDTO);

    ModuleDTO updateModule(Long id, ModuleDTO moduleDTO);

    void deleteModule(Long id);
}
