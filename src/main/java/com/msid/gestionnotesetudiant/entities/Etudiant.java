package com.msid.gestionnotesetudiant.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Etudiant implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
   @Column(unique=true)
    private String username;
    private String password;
    private String email;
    private String niveau;
    private String classe;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Matiere> matieres = new ArrayList<>();
    



}
