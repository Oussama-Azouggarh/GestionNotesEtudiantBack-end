package com.msid.gestionnotesetudiant.service;

import com.msid.gestionnotesetudiant.entities.Admin;
import com.msid.gestionnotesetudiant.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin getAdminByUsernameAndPassword(String username,String password) {

        Admin admin = adminRepository.findByUsernameAndPassword(username,password);

        return admin;
    }
    

}
