package com.project.gestionemploi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.ModuleRepository;
import com.project.gestionemploi.dto.ModuleDTO;

import java.util.List;
import java.util.stream.Collectors;
import com.project.gestionemploi.models.Module;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<ModuleDTO> getAllModules() {
        List<Module> modules = moduleRepository.findAll();
        return modules.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ModuleDTO getModuleById(Long id) {
        Module moduleEntity = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
        return convertToDTO(moduleEntity);
    }

    @Override
    public ModuleDTO createModule(ModuleDTO moduleDTO) {
        Module newModule = new Module();
        newModule.setName(moduleDTO.getName());
       
        Module savedModule = moduleRepository.save(newModule);
        return convertToDTO(savedModule);
    }

    @Override
    public ModuleDTO updateModule(Long id, ModuleDTO moduleDTO) {
        Module existingModule = moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        existingModule.setName(moduleDTO.getName());
        
        Module updatedModule = moduleRepository.save(existingModule);
        return convertToDTO(updatedModule);
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    private ModuleDTO convertToDTO(Module moduleEntity) {
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setId(moduleEntity.getId());
        moduleDTO.setName(moduleEntity.getName());
        
        return moduleDTO;
    }

}
