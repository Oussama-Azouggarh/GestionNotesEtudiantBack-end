package com.msid.gestionnotesetudiant;

import com.msid.gestionnotesetudiant.entities.Admin;
import com.msid.gestionnotesetudiant.entities.Etudiant;
import com.msid.gestionnotesetudiant.entities.Matiere;
import com.msid.gestionnotesetudiant.entities.Note;
import com.msid.gestionnotesetudiant.repository.AdminRepository;
import com.msid.gestionnotesetudiant.repository.EtudiantRepository;
import com.msid.gestionnotesetudiant.repository.MatiereRepository;
import com.msid.gestionnotesetudiant.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.msid.gestionnotesetudiant.*")
public class GestionNotesEtudiantApplication {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(GestionNotesEtudiantApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository, NoteRepository noteRepository, MatiereRepository matiereRepository, AdminRepository adminRepository){

		restConfiguration.exposeIdsFor(Etudiant.class);
		restConfiguration.exposeIdsFor(Matiere.class);
		restConfiguration.exposeIdsFor(Note.class);

		return args -> {
			Etudiant E1=Etudiant.builder().firstName("ayoub").lastName("hamdoune")
					.email("ayoub@msid.com").niveau("tcs").username("ayoub").password("ayoub").classe("A")
					.build();
			etudiantRepository.save(E1);

			Etudiant E2=Etudiant.builder().firstName("oussama").lastName("azouggarh")
					.email("oussama@msid.com").niveau("tcs").classe("B").username("oussama").password("oussama")
					.build();
			etudiantRepository.save(E2);

			Etudiant E3=Etudiant.builder().firstName("driss").lastName("echouikhi")
					.email("driss@msid.com").niveau("tcs").classe("A").username("driss").password("driss")
					.build();
			etudiantRepository.save(E3);


			adminRepository.save(Admin.builder().firstName("Anass").lastName("ARISS").email("anas@msid.com")
					.username("anas").password("anas").build());
			adminRepository.save(Admin.builder().firstName("Soumia").lastName("ZITI").email("ziti@msid.com")
					.username("ziti").password("ziti").build());





				Matiere matiere2=Matiere.builder().Nom("Mathématiques").devoir1(10).devoir2(14).devoir3(20).Coeff(4).etudiant(E1).build();
				matiere2.calculerMoyenneMatiere();
				matiereRepository.save(matiere2);
				Note note2= Note.builder().Valeur(matiere2.getNoteMatiere()).etudiant(E1).matiere(matiere2).build();
				noteRepository.save(note2);

				Matiere matiere1=Matiere.builder().Nom("Physique et Chimie").devoir1(15).devoir2(14).devoir3(20).Coeff(4).etudiant(E1).build();
				matiere1.calculerMoyenneMatiere();
				matiereRepository.save(matiere1);
				Note note1= Note.builder().Valeur(matiere1.getNoteMatiere()).etudiant(E1).matiere(matiere1).build();
				noteRepository.save(note1);

                Matiere matiere0=Matiere.builder().Nom("Sciences de la Vie et de la Terre").devoir1(15).devoir2(14).devoir3(20).Coeff(4).etudiant(E1).build();
                matiere0.calculerMoyenneMatiere();
                matiereRepository.save(matiere0);
                Note note0= Note.builder().Valeur(matiere0.getNoteMatiere()).etudiant(E1).matiere(matiere0).build();
                noteRepository.save(note1);

				Matiere matiere3=Matiere.builder().Nom("Français").devoir1(16).devoir2(14).devoir3(20).Coeff(3).etudiant(E1).build();
				matiere3.calculerMoyenneMatiere();
				matiereRepository.save(matiere3);
				Note note3= Note.builder().Valeur(matiere3.getNoteMatiere()).etudiant(E1).matiere(matiere3).build();
				noteRepository.save(note3);

				Matiere matiere4=Matiere.builder().Nom("Anglais").devoir1(17).devoir2(14).devoir3(11).Coeff(3).etudiant(E1).build();
				matiere4.calculerMoyenneMatiere();
				matiereRepository.save(matiere4);
				Note note4= Note.builder().Valeur(matiere4.getNoteMatiere()).etudiant(E1).matiere(matiere4).build();
				noteRepository.save(note4);

				Matiere matiere5=Matiere.builder().Nom("Informatique").devoir1(12).devoir2(14).devoir3(20).Coeff(2).etudiant(E1).build();
				matiere5.calculerMoyenneMatiere();
				matiereRepository.save(matiere5);
				Note note5= Note.builder().Valeur(matiere5.getNoteMatiere()).etudiant(E1).matiere(matiere5).build();
				noteRepository.save(note5);

				Matiere matiere6=Matiere.builder().Nom("Arabe").devoir1(13).devoir2(14).devoir3(14).Coeff(2).etudiant(E1).build();
				matiere6.calculerMoyenneMatiere();
				matiereRepository.save(matiere6);
				Note note6= Note.builder().Valeur(matiere6.getNoteMatiere()).etudiant(E1).matiere(matiere6).build();
				noteRepository.save(note6);

				Matiere matiere7=Matiere.builder().Nom("Éducation Islamique").devoir1(9.9).devoir2(14).devoir3(20).Coeff(2).etudiant(E1).build();
				matiere7.calculerMoyenneMatiere();
				matiereRepository.save(matiere7);
				Note note7= Note.builder().Valeur(matiere7.getNoteMatiere()).etudiant(E1).matiere(matiere7).build();
				noteRepository.save(note7);

				Matiere matiere8=Matiere.builder().Nom("Histoire et Géographie").devoir1(19).devoir2(14).devoir3(10).Coeff(2).etudiant(E1).build();
				matiere8.calculerMoyenneMatiere();
				matiereRepository.save(matiere8);
				Note note8= Note.builder().Valeur(matiere8.getNoteMatiere()).etudiant(E1).matiere(matiere8).build();
				noteRepository.save(note8);

				Matiere matiere9=Matiere.builder().Nom("Philosophie").devoir1(15).devoir2(14).devoir3(20).Coeff(2).etudiant(E1).build();
				matiere9.calculerMoyenneMatiere();
				matiereRepository.save(matiere9);
				Note note9= Note.builder().Valeur(matiere9.getNoteMatiere()).etudiant(E1).matiere(matiere9).build();
				noteRepository.save(note9);

				Matiere matiere=Matiere.builder().Nom("Éducation physique et sportive").devoir1(15.0).devoir2(12).devoir3(17).Coeff(2).etudiant(E1).build();
				matiere.calculerMoyenneMatiere();
				matiereRepository.save(matiere);
				Note note= Note.builder().Valeur(matiere.getNoteMatiere()).etudiant(E1).matiere(matiere).build();
				noteRepository.save(note);

				Matiere matiere10=Matiere.builder().Nom("Sciences de l'ingénieur").devoir1(15.0).devoir2(12).devoir3(17).Coeff(2).etudiant(E1).build();
				matiere10.calculerMoyenneMatiere();
				matiereRepository.save(matiere10);
				Note note10= Note.builder().Valeur(matiere10.getNoteMatiere()).etudiant(E1).matiere(matiere10).build();
				noteRepository.save(note10);


//------------------------------------------------------------------------------------------------------------------------------------------------------


				Matiere matiere11=Matiere.builder().Nom("Mathématiques").devoir1(19).devoir2(18).devoir3(20).Coeff(4).etudiant(E2).build();
				matiere11.calculerMoyenneMatiere();
				matiereRepository.save(matiere11);
				
				noteRepository.save(note2);

				Matiere matiere12=Matiere.builder().Nom("Physique et Chimie").devoir1(18).devoir2(17).devoir3(20).Coeff(4).etudiant(E2).build();
				matiere12.calculerMoyenneMatiere();
				matiereRepository.save(matiere12);
				
				noteRepository.save(note1);

                Matiere matiere120=Matiere.builder().Nom("Sciences de la Vie et de la Terre").devoir1(15).devoir2(14).devoir3(20).Coeff(4).etudiant(E2).build();
                matiere120.calculerMoyenneMatiere();
                matiereRepository.save(matiere120);
                
                noteRepository.save(note1);

				Matiere matiere13=Matiere.builder().Nom("Français").devoir1(16).devoir2(16).devoir3(16).Coeff(3).etudiant(E2).build();
				matiere13.calculerMoyenneMatiere();
				matiereRepository.save(matiere13);
				
				noteRepository.save(note3);

				Matiere matiere14=Matiere.builder().Nom("Anglais").devoir1(17).devoir2(14).devoir3(11).Coeff(3).etudiant(E2).build();
				matiere14.calculerMoyenneMatiere();
				matiereRepository.save(matiere14);
				
				noteRepository.save(note4);

				Matiere matiere15=Matiere.builder().Nom("Informatique").devoir1(15).devoir2(14).devoir3(20).Coeff(2).etudiant(E2).build();
				matiere15.calculerMoyenneMatiere();
				matiereRepository.save(matiere15);
				
				noteRepository.save(note5);

				Matiere matiere16=Matiere.builder().Nom("Arabe").devoir1(13).devoir2(14).devoir3(14).Coeff(2).etudiant(E2).build();
				matiere16.calculerMoyenneMatiere();
				matiereRepository.save(matiere16);
				
				noteRepository.save(note6);

				Matiere matiere17=Matiere.builder().Nom("Éducation Islamique").devoir1(19).devoir2(19).devoir3(20).Coeff(2).etudiant(E2).build();
				matiere17.calculerMoyenneMatiere();
				matiereRepository.save(matiere17);
				
				noteRepository.save(note7);

				Matiere matiere18=Matiere.builder().Nom("Histoire et Géographie").devoir1(19).devoir2(14).devoir3(10).Coeff(2).etudiant(E2).build();
				matiere18.calculerMoyenneMatiere();
				matiereRepository.save(matiere18);
				
				noteRepository.save(note8);

				Matiere matiere19=Matiere.builder().Nom("Philosophie").devoir1(12).devoir2(12).devoir3(12).Coeff(2).etudiant(E2).build();
				matiere19.calculerMoyenneMatiere();
				matiereRepository.save(matiere19);
				
				noteRepository.save(note9);

				Matiere matiere20=Matiere.builder().Nom("Éducation physique et sportive").devoir1(17).devoir2(17).devoir3(17).Coeff(2).etudiant(E2).build();
				matiere20.calculerMoyenneMatiere();
				matiereRepository.save(matiere20);
			
				noteRepository.save(note);

				Matiere matiere21=Matiere.builder().Nom("Sciences de l'ingénieur").devoir1(15.0).devoir2(12).devoir3(17).Coeff(2).etudiant(E2).build();
				matiere21.calculerMoyenneMatiere();
				matiereRepository.save(matiere21);

				noteRepository.save(note10);



//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

				Matiere matiere22=Matiere.builder().Nom("Mathématiques").devoir1(20).devoir2(20).devoir3(20).Coeff(4).etudiant(E3).build();
				matiere22.calculerMoyenneMatiere();
				matiereRepository.save(matiere22);
				
				noteRepository.save(note2);

				Matiere matiere00=Matiere.builder().Nom("Physique et Chimie").devoir1(14).devoir2(14).devoir3(14).Coeff(4).etudiant(E3).build();
				matiere00.calculerMoyenneMatiere();
				matiereRepository.save(matiere00);
				
				noteRepository.save(note1);

                Matiere matiere23=Matiere.builder().Nom("Sciences de la Vie et de la Terre").devoir1(15).devoir2(14).devoir3(17).Coeff(4).etudiant(E3).build();
                matiere23.calculerMoyenneMatiere();
                matiereRepository.save(matiere23);
                
                noteRepository.save(note1);

				Matiere matiere24=Matiere.builder().Nom("Français").devoir1(19).devoir2(19).devoir3(20).Coeff(3).etudiant(E3).build();
				matiere24.calculerMoyenneMatiere();
				matiereRepository.save(matiere24);
				
				noteRepository.save(note3);

				Matiere matiere25=Matiere.builder().Nom("Anglais").devoir1(17).devoir2(19).devoir3(18).Coeff(3).etudiant(E3).build();
				matiere25.calculerMoyenneMatiere();
				matiereRepository.save(matiere25);
				
				noteRepository.save(note4);

				Matiere matiere26=Matiere.builder().Nom("Informatique").devoir1(12).devoir2(14).devoir3(16).Coeff(2).etudiant(E3).build();
				matiere26.calculerMoyenneMatiere();
				matiereRepository.save(matiere26);
				
				noteRepository.save(note5);

				Matiere matiere27=Matiere.builder().Nom("Arabe").devoir1(13).devoir2(14).devoir3(14).Coeff(2).etudiant(E3).build();
				matiere27.calculerMoyenneMatiere();
				matiereRepository.save(matiere27);
				
				noteRepository.save(note6);

				Matiere matiere28=Matiere.builder().Nom("Éducation Islamique").devoir1(19.5).devoir2(14).devoir3(15).Coeff(2).etudiant(E3).build();
				matiere28.calculerMoyenneMatiere();
				matiereRepository.save(matiere28);
				
				noteRepository.save(note7);

				Matiere matiere29=Matiere.builder().Nom("Histoire et Géographie").devoir1(19).devoir2(18).devoir3(19).Coeff(2).etudiant(E3).build();
				matiere29.calculerMoyenneMatiere();
				matiereRepository.save(matiere29);
				
				noteRepository.save(note8);

				Matiere matiere30=Matiere.builder().Nom("Philosophie").devoir1(15).devoir2(14).devoir3(20).Coeff(2).etudiant(E3).build();
				matiere30.calculerMoyenneMatiere();
				matiereRepository.save(matiere30);
				
				noteRepository.save(note9);

				Matiere matiere31=Matiere.builder().Nom("Éducation physique et sportive").devoir1(15.0).devoir2(12).devoir3(17).Coeff(2).etudiant(E3).build();
				matiere31.calculerMoyenneMatiere();
				matiereRepository.save(matiere31);
			
				noteRepository.save(note);

				Matiere matiere32=Matiere.builder().Nom("Sciences de l'ingénieur").devoir1(15.0).devoir2(12).devoir3(17).Coeff(2).etudiant(E3).build();
				matiere32.calculerMoyenneMatiere();
				matiereRepository.save(matiere32);

				noteRepository.save(note10);









			



		};
	}
}
