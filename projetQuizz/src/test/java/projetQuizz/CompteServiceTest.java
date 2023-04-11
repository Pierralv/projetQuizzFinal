package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Compte;
import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;
import projetQuizz.entities.Role;
import projetQuizz.services.CompteService;
import projetQuizz.services.QuestionService;
import projetQuizz.services.ReponseService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
//@Rollback
public class CompteServiceTest {
	
	@Autowired 
	CompteService compteSrv;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	ReponseService reponseService;
	
	private Question q = new Question("enoncee", null);
	
	@Test
	@Commit
	void initCompte() {
		Compte compte1 = new Compte("nom", "prenom", "pseudo", "avatar", "email", "mdp", Role.ROLE_ADMIN);
		compteSrv.createOrUpdate(compte1);
		questionService.createOrUpdate(q);	
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		q.setCreateur(compte1);
		compteSrv.createOrUpdate(compte1);
		System.out.println("get by id:");
		System.out.println(compteSrv.getById(1L));
		System.out.println("get all");
		System.out.println(compteSrv.getAll());
		System.out.println("get questions");
		System.out.println(compteSrv.getByIdWithQuestions(1L));
		compteSrv.deleteById(1L);
		System.out.println("delete");
		System.out.println(compteSrv.getAll());
	}
	
	
	
	

}
