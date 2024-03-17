package com.project.gestionemploi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.ParentRepository;
import com.project.gestionemploi.Repository.StudentRepository;
import com.project.gestionemploi.dto.ParentDTO;
import com.project.gestionemploi.models.Parent;
import com.project.gestionemploi.models.Student;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;
    

    @Autowired
    private StudentRepository studentRepository;

   
    @Override
    public List<ParentDTO> getAllParentes() {
        List<Parent> parentes = parentRepository.findAll();
        return parentes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ParentDTO getParentById(Long id) {
        Parent parentEntity = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        return convertToDTO(parentEntity);
    }

    @Override
    public ParentDTO createParent(ParentDTO parentDTO) {
        Parent newParent = new Parent();

        newParent.setName(parentDTO.getName());
        newParent.setTel(parentDTO.getTel());
        Parent savedParent = parentRepository.save(newParent);
        return convertToDTO(savedParent);
    }

    @Override
    public ParentDTO updateParent(Long id, ParentDTO parentDTO) {
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));

        existingParent.setName(parentDTO.getName());
        existingParent.setTel(parentDTO.getTel());

        Parent updatedParent = parentRepository.save(existingParent);
        return convertToDTO(updatedParent);
    }

    // @Override
    // public void deleteParent(Long id) {
    //     parentRepository.deleteById(id);
    // }

    

    private ParentDTO convertToDTO(Parent parentEntity) {
        ParentDTO parentDTO = new ParentDTO();
        parentDTO.setId(parentEntity.getId());
        parentDTO.setName(parentEntity.getName());
        parentDTO.setTel(parentEntity.getTel());
        return parentDTO;
    }



    @Override
    public void deleteParent(Long parentId) {
        // Récupérer le parent
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + parentId));
    
        // Récupérer tous les étudiants associés au parent
        List<Student> students = parent.getStudents();
    
        // Supprimer tous les étudiants associés au parent
        for (Student student : students) {
            student.removeParent(); // Dissocier l'étudiant du parent
            studentRepository.save(student);
        }
    
        // Enfin, supprimer le parent lui-même
        parentRepository.deleteById(parentId);
    }
}
