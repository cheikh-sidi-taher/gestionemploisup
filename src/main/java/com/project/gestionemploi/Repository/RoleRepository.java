package com.project.gestionemploi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
