package com.msid.gestionnotesetudiant.entities;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Matiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;

    private double devoir1;

    private double devoir2;


    private double devoir3;
    private int Coeff;


    private double noteMatiere=0.0;

    @ManyToOne/*(cascade = CascadeType.REMOVE)*/
    @JoinColumn(name = "id_Etudiant")
    private Etudiant etudiant;


    @OneToMany(mappedBy = "matiere", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>(); // Corrected initializer


    public void calculerMoyenneMatiere() {

         double sommeDevoirs = this.devoir1 + this.devoir2 + this.devoir3;
          this.noteMatiere=sommeDevoirs / 3 ;

    }


}
