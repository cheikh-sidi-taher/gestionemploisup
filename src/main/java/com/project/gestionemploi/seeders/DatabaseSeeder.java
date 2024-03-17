package com.project.gestionemploi.seeders;

import com.project.gestionemploi.Repository.RoleRepository;
import com.project.gestionemploi.Repository.UserRepository;
import com.project.gestionemploi.models.Role;
import com.project.gestionemploi.models.User;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseSeeder(RoleRepository roleRepository, UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void seed() {
     // Seed users and assign roles
if (userRepository.findByEmail("admin@gmail.com") == null) {
    User adminUser = new User();
    adminUser.setName("admin");
    adminUser.setEmail("admin@gmail.com");
    adminUser.setPassword(passwordEncoder.encode("1234"));
    User savedUser = userRepository.save(adminUser);
    
    // Retrieve the ROLE_ADMIN role
    Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
    if (roleAdmin == null) {
        // If the ROLE_ADMIN role doesn't exist, create it
        roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleAdmin = roleRepository.save(roleAdmin);
    }
    
    // Assign the ROLE_ADMIN role to the user
    savedUser.addRole(roleAdmin);
    userRepository.save(savedUser);
}

}}