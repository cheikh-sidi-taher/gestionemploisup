package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.SessionDTO;

public interface SessionService {
    List<SessionDTO> getAllSessions();
    
    SessionDTO getSessionById(Long id);

    SessionDTO createSession(SessionDTO sessionDTO);

    SessionDTO updateSession(Long id, SessionDTO sessionDTO);

    void deleteSession(Long id);

   
    
}