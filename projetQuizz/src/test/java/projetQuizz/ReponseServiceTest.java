package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Reponse;
import projetQuizz.services.ReponseService;

@SpringJUnitConfig(JpaConfig.class)
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
		System.out.println(reponseService.getById(1L));

		System.out.println("------------getByEnonce------------");
		System.out.println(reponseService.getByEnonce("proposition2SurUnFilm"));

		System.out.println("------------getByEnonceContaining------------");
		System.out.println(reponseService.getByEnonceContaining("4"));
	}

}
