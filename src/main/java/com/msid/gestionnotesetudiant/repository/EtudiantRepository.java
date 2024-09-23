package com.msid.gestionnotesetudiant.repository;

import com.msid.gestionnotesetudiant.entities.Etudiant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
//@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
/*
    Optional<Etudiant> findById(long id);
    Optional<Etudiant> findById(long id);
    Optional<Etudiant> findByNiveau(String niveau);
    Optional<Etudiant> findByFirstName(String firstName);
    Optional<Etudiant> findByLastName(String lastName);

*/

    Optional<Etudiant> findByNiveau(String niveau);
    @RestResource(path = "/byFirstName")
    public List<Etudiant> findByFirstNameContains(@Param("mc") String first);
    @RestResource (path = "/byFirstNamePage")
    public Page<Etudiant> findByFirstNameContains(@Param("mc") String first, Pageable pageable);

    @RestResource (path = "/byLastName")
    public List<Etudiant> findByLastNameContains(@Param("mc") String last);
    @RestResource (path = "/byLastNamePage")
    public Page<Etudiant> findByLastNameContains(@Param("mc") String last, Pageable pageable);

    @RestResource (path = "/byNiveau")
    public List<Etudiant> findByNiveauContains(@Param("mc") String niveau);
    @RestResource (path = "/byNiveauPage")
    public Page<Etudiant> findByNiveauContains(@Param("mc") String niveau, Pageable pageable);


    Etudiant findByUsernameAndPassword(String username, String password);
}
