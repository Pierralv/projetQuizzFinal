package ajc.formation.soprasteria.projetQuizzSB.controllers;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.formation.soprasteria.projetQuizzSB.entities.Compte;
import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.entities.Role;
import ajc.formation.soprasteria.projetQuizzSB.services.CompteService;
import ajc.formation.soprasteria.projetQuizzSB.services.QuestionService;
import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;

@SpringBootTest
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
		compteSrv.createUser(compte1);
		questionService.createOrUpdate(q);	
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		q.setCreateur(compte1);
		compteSrv.update(compte1);
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
