package com.msid.gestionnotesetudiant.repository;



import com.msid.gestionnotesetudiant.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
//@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note,Long> {
}
