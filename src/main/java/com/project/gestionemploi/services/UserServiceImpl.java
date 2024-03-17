package com.project.gestionemploi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.gestionemploi.Repository.RoleRepository;
import com.project.gestionemploi.Repository.UserRepository;
import com.project.gestionemploi.dto.UserDto;
import com.project.gestionemploi.models.Role;
import com.project.gestionemploi.models.User;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

   @Override
public void saveUser(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getFirstName() + " " + userDto.getLastName());
    user.setEmail(userDto.getEmail());
    // Encrypt the password using Spring Security
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));

    // Create a list to hold user's roles
    Set<Role> userRoles = new HashSet<>();


    // Iterate through role names provided in userDto
    for (String roleName : userDto.getRoles()) {
        // Check if the role already exists in the database
        Role role = roleRepository.findByName(roleName);
        // If role doesn't exist, create a new one
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            roleRepository.save(role); // Save the newly created role
        }
        // Add the role to the user's roles list
        userRoles.add(role);
    }

    // Set the user's roles
    user.setRoles(userRoles);

    // Save the user
    userRepository.save(user);
}

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        
        // Diviser le nom complet en prénom et nom de famille
        String[] nameParts = user.getName().split(" ", 2);
        for (int i = 0; i < nameParts.length; i++) {
            if (i == 0) {
                userDto.setFirstName(nameParts[i]);
            } else if (i == 1) {
                userDto.setLastName(nameParts[i]);
            }
        }
        
        userDto.setEmail(user.getEmail());
        
        // Conversion de l'identifiant de type Long en String puis en Long
        try {
            String userIdString = String.valueOf(user.getId());
            Long userId = Long.parseLong(userIdString);
            userDto.setId(userId);
        } catch (NumberFormatException e) {
            // Gérer l'exception en fonction de vos besoins
            e.printStackTrace();
        }
        
        // Ajout des rôles
        List<String> roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
        }
        userDto.setRoles(roles);
        
        return userDto;
    }
    
    

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }



    
}