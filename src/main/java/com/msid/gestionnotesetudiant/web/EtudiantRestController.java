package com.msid.gestionnotesetudiant.web;


import com.msid.gestionnotesetudiant.entities.Admin;
import com.msid.gestionnotesetudiant.entities.Etudiant;
import com.msid.gestionnotesetudiant.entities.Matiere;
import com.msid.gestionnotesetudiant.repository.EtudiantRepository;
import com.msid.gestionnotesetudiant.repository.MatiereRepository;
import com.msid.gestionnotesetudiant.service.EtudiantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private MatiereRepository matiereRepository;


    @GetMapping(value="/listEtudiants")
    public List<Etudiant> listEtudiants(){
        return etudiantRepository.findAll();
    }

    @GetMapping(value="/listEtudiantId/{id}")
    public Etudiant listEtudiantId (@PathVariable(name="id") Long id) {
        return etudiantRepository.findById(id).get();
    }

    @GetMapping(value="/listEtudiantNiveau/{niveau}")
    public Etudiant listEtudiantNiveau (@PathVariable(name="niveau") String niveau) {
        return etudiantRepository.findByNiveau(niveau).get();
    }



    @PutMapping(value="/listEtudiants/{id}")
    public Etudiant update(@PathVariable(name="id") Long id,@RequestBody Etudiant p){
        p.setId(id);
        return etudiantRepository.save(p);

    }

    @PostMapping(value="/listEtudiants")
    public Etudiant save(@RequestBody Etudiant p) {
        return etudiantRepository.save(p);
    }

    @Transactional
    @DeleteMapping(value="/listEtudiants/{id}")
    public void deleteEtudiant(@PathVariable(name="id") Long id,@PathVariable(name="id") Long id_etudiant) {
        etudiantRepository.deleteById(id);
    }

    @GetMapping(path = "/find/{username}/{password}")
    public Etudiant getEtudiantByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {

        Etudiant etudiant = etudiantService.getEtudiantByUsernameAndPassword(username, password);

        return etudiant;
    }





}
