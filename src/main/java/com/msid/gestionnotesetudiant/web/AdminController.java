package com.msid.gestionnotesetudiant.web;

import com.msid.gestionnotesetudiant.entities.Admin;
import com.msid.gestionnotesetudiant.repository.AdminRepository;
import com.msid.gestionnotesetudiant.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminService adminService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @GetMapping(path = "/find/{id}")
    public Admin getAdmin(@PathVariable Long id) {

        return adminRepository.findById(id).get();
    }

    @GetMapping(path = "/find/{username}/{password}")
    public Admin getAdminByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {

        Admin admin = adminService.getAdminByUsernameAndPassword(username, password);

        return admin;
    }


    }
