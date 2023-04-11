package projetQuizz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Compte;
import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;
import projetQuizz.entities.Role;
import projetQuizz.entities.Theme;
import projetQuizz.services.CompteService;
import projetQuizz.services.QuestionService;
import projetQuizz.services.ReponseService;
import projetQuizz.services.ThemeService;

@SpringJUnitConfig(JpaConfig.class)
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
