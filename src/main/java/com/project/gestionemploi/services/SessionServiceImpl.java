package com.project.gestionemploi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.SessionRepository;
import com.project.gestionemploi.dto.SessionDTO;
import com.project.gestionemploi.models.Session;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<SessionDTO> getAllSessions() {
        List<Session> Sessions = sessionRepository.findAll();
        return Sessions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public SessionDTO getSessionById(Long id) {
        Session sessionEntity = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));
        return convertToDTO(sessionEntity);
    }

    @Override
    public SessionDTO createSession(SessionDTO sessionDTO) {
        Session newSession = new Session();

        newSession.setStartTime(sessionDTO.getStartTime());
        newSession.setEndTime(sessionDTO.getEndTime());
        newSession.setType(sessionDTO.getType());
        newSession.setClasseId(sessionDTO.getClasseId());
        newSession.setTeacherId(sessionDTO.getTeacherId());
        newSession.setModuleId(sessionDTO.getModuleId());

        Session savedSession = sessionRepository.save(newSession);
        return convertToDTO(savedSession);
    }

    @Override
    public SessionDTO updateSession(Long id, SessionDTO sessionDTO) {
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));

        existingSession.setStartTime(sessionDTO.getStartTime());
        existingSession.setEndTime(sessionDTO.getEndTime());
        existingSession.setType(sessionDTO.getType());
       
        existingSession.setClasseId(sessionDTO.getClasseId());
        existingSession.setTeacherId(sessionDTO.getTeacherId());
        existingSession.setModuleId(sessionDTO.getModuleId());

        Session updatedSession = sessionRepository.save(existingSession);
        return convertToDTO(updatedSession);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    private SessionDTO convertToDTO(Session sessionEntity) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(sessionEntity.getId());
        sessionDTO.setStartTime(sessionEntity.getStartTime());
        sessionDTO.setEndTime(sessionEntity.getEndTime());
        sessionDTO.setType(sessionEntity.getType());
        sessionDTO.setClasseId(sessionEntity.getClasseId());
        sessionDTO.setTeacherId(sessionEntity.getTeacherId());
        sessionDTO.setModuleId(sessionEntity.getModuleId());

        return sessionDTO;
    }
}
