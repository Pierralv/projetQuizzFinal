package ajc.formation.soprasteria.projetQuizzSB.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.formation.soprasteria.projetQuizzSB.entities.Compte;
import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.entities.Role;
import ajc.formation.soprasteria.projetQuizzSB.entities.Theme;
import ajc.formation.soprasteria.projetQuizzSB.services.CompteService;
import ajc.formation.soprasteria.projetQuizzSB.services.QuestionService;
import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;
import ajc.formation.soprasteria.projetQuizzSB.services.ThemeService;

@SpringBootTest
@Transactional
public class ThemeServiceTest {	
	
	@Autowired
	ThemeService themeService;
	@Autowired
	QuestionService questionService;	
	@Autowired 
	ReponseService reponseService;
	@Autowired 
	CompteService compteSrv;
	
	private Compte compte1 = new Compte("nom", "prenom", "pseudo", "avatar", "email", "mdp", Role.ROLE_ADMIN);
	private Theme t = new Theme("nom");
	private Question q = new Question("enonce", t, compte1);

	@Commit
	@Test
	void initTheme() {
		themeService.createOrUpdate(t);
		compteSrv.createOrUpdate(compte1);
		questionService.createOrUpdate(q);
		Reponse rep1 = new Reponse("enonce de la reponse", false, q);
		Reponse rep2 = new Reponse("enonce de la reponse", false, q);
		Reponse rep3 = new Reponse("enonce de la reponse", false, q);
		Reponse rep4 = new Reponse("enonce de la reponse", false, q);
		reponseService.createOrUpdate(rep1);
		reponseService.createOrUpdate(rep2);
		reponseService.createOrUpdate(rep3);
		reponseService.createOrUpdate(rep4);
		assertNotNull(questionService.getById(q.getId()));
		System.out.println(questionService.getAll());
		System.out.println(reponseService.getAll());
		System.out.println(questionService.getIdWithReponses(q.getId()));
		themeService.createOrUpdate(t);
		System.out.println(themeService.getAll());
		System.out.println(themeService.getById(t.getId()));
		System.out.println(themeService.getIdWithQuestions(t.getId()));
		
		themeService.delete(t);
	}

}
