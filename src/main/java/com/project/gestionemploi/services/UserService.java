package com.project.gestionemploi.services;

import java.util.List;

import com.project.gestionemploi.dto.TeacherDTO;
import com.project.gestionemploi.dto.UserDto;
import com.project.gestionemploi.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

   
    
   
   
}
