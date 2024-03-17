package com.project.gestionemploi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestionemploi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String name);

    User findByPassword(String password);

   

    

}
