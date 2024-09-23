package com.msid.gestionnotesetudiant.entities;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Note implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double Valeur;

    @ManyToOne
    @JoinColumn(name = "id_Etudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

}
