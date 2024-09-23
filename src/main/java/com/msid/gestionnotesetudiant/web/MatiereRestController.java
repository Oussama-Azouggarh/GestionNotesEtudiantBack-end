package com.msid.gestionnotesetudiant.web;

import com.msid.gestionnotesetudiant.entities.Matiere;
import com.msid.gestionnotesetudiant.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/matiere")
public class MatiereRestController {
    @Autowired
    private MatiereRepository matiereRepository;

    @GetMapping(value = "/listMatieres")
    public List<Matiere> listMatieres(){
        return matiereRepository.findAll();
    }

    @PutMapping(value="/listMatieres/{id}")
    public Matiere update(@PathVariable(name="id") Long id,@RequestBody Matiere p){
        p.setId(id);
        p.calculerMoyenneMatiere();
        System.out.println("Updated Matiere: " + p);
        return matiereRepository.save(p);

    }

    @PostMapping(value="/listMatieres")
    public Matiere save(@RequestBody Matiere p) {
        p.calculerMoyenneMatiere();
        return matiereRepository.save(p);
    }

    @DeleteMapping(value="/listMatieres/{id}")
    public void deleteMatiere(@PathVariable(name="id") Long id) {
        matiereRepository.deleteById(id);
    }
}
