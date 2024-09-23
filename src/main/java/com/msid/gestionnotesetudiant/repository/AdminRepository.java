package com.msid.gestionnotesetudiant.repository;

import com.msid.gestionnotesetudiant.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")

public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByUsernameAndPassword(String username, String password);
}
