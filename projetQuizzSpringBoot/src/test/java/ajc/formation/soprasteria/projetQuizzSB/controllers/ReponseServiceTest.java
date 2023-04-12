package ajc.formation.soprasteria.projetQuizzSB.controllers;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;

@SpringBootTest
@Transactional
public class ReponseServiceTest {	
	@Autowired
	ReponseService reponseService;
	
	
	@Test
	// @Commit
	void test() {
		Reponse reponse1 = new Reponse("proposition1SurUnFilm", true);
		Reponse reponse2 = new Reponse("proposition2SurUnFilm", false);
		Reponse reponse3  = new Reponse("proposition3SurUnFilm", false);
		Reponse reponse4  = new Reponse("proposition4SurUnFilm", false);
		reponseService.createOrUpdate(reponse1);
		reponseService.createOrUpdate(reponse2);
		reponseService.createOrUpdate(reponse3);
		reponseService.createOrUpdate(reponse4);

		System.out.println("------------getAll------------");
		System.out.println(reponseService.getAll());

		System.out.println("------------getById------------");
		System.out.println(reponse1.getId());

		System.out.println("------------getByEnonce------------");
		System.out.println(reponseService.getByEnonce("proposition2SurUnFilm"));

		System.out.println("------------getByEnonceContaining------------");
		System.out.println(reponseService.getByEnonceContaining("4"));
	}

}
