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
public class AllServiceTest {	
	
	@Autowired 
	CompteService compteSrv;
	@Autowired
	ThemeService themeService;
	@Autowired
	QuestionService questionService;	
	@Autowired 
	ReponseService reponseService;
	
	private Compte compte1 = new Compte("nomAdmin", "prenomAdmin", "pseudoAdmin", "avatarAdmin", "emailAdmin", "mdp", Role.ROLE_ADMIN);
	private Compte compte2 = new Compte("nom1", "prenom1", "pseudo1", "avatar1", "email1", "mdp", Role.ROLE_UTILISATEUR);
	private Compte compte3 = new Compte("nom2", "prenom2", "pseudo2", "avatar2", "email2", "mdp", Role.ROLE_UTILISATEUR);
	private Theme theme = new Theme("film");
	private Question question = new Question("enonce", theme, compte1);

	@Commit
	@Test
	void initTheme() {
		themeService.createOrUpdate(theme);
		themeService.createOrUpdate(new Theme("histoire"));
		compteSrv.createAdmin(compte1);
		compteSrv.createUser(compte2);
		compteSrv.createUser(compte3);
		questionService.createOrUpdate(question);
		Reponse rep1 = new Reponse("enonce de la reponse1", false, question);
		Reponse rep2 = new Reponse("enonce de la reponse2", true, question);
		Reponse rep3 = new Reponse("enonce de la reponse3", false, question);
		Reponse rep4 = new Reponse("enonce de la reponse4", false, question);
		reponseService.createOrUpdate(rep1);
		reponseService.createOrUpdate(rep2);
		reponseService.createOrUpdate(rep3);
		reponseService.createOrUpdate(rep4);
		System.out.println(compteSrv.getAll());
		System.out.println(compteSrv.getById(compte1.getId()));
		System.out.println(themeService.getAll());
		System.out.println(themeService.getById(theme.getId()));
		System.out.println(themeService.getIdWithQuestions(theme.getId()));
		System.out.println(questionService.getAll());
		System.out.println(questionService.getById(question.getId()));
		System.out.println(questionService.getIdWithReponses(question.getId()));
		// System.out.println((questionService.getByCreateur(compte1))); 
		System.out.println(reponseService.getAll());
		System.out.println(reponseService.getById(rep1.getId()));
		System.out.println(reponseService.getByEnonceContaining("reponse2"));
	}

}
