package com.msid.gestionnotesetudiant.service;

import com.msid.gestionnotesetudiant.entities.Etudiant;

import com.msid.gestionnotesetudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service
public class EtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;

    public Etudiant getEtudiantByUsernameAndPassword(String username, String password) {

        Etudiant etudiant = etudiantRepository.findByUsernameAndPassword(username,password);

        return etudiant;
    }

}
