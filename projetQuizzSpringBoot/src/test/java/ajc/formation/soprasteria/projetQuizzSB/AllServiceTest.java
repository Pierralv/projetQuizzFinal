package ajc.formation.soprasteria.projetQuizzSB;

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
	
	private Compte compte1 = new Compte("nomAdmin", "prenomAdmin", "admin", "avatarAdmin", "emailAdmin", "admin", Role.ROLE_ADMIN);
	private Compte compte2 = new Compte("nom1", "prenom1", "user1", "avatar1", "email1", "user1", Role.ROLE_UTILISATEUR);
	private Compte compte3 = new Compte("nom2", "prenom2", "user2", "avatar2", "email2", "user2", Role.ROLE_UTILISATEUR);
	private Theme theme = new Theme("film");
	private Question question = new Question("enonce q1", theme, compte1);

	@Commit
	@Test
	void initTheme() {
		themeService.createOrUpdate(theme);
		themeService.createOrUpdate(new Theme("histoire"));
		themeService.createOrUpdate(new Theme("musique"));
		compteSrv.createAdmin(compte1);
		compteSrv.createUser(compte2);
		compteSrv.createUser(compte3);
		questionService.createOrUpdate(question);
		Reponse rep1 = new Reponse("rep1 q1", false, question);
		Reponse rep2 = new Reponse("rep2 q1", true, question);
		Reponse rep3 = new Reponse("rep3 q1", false, question);
		Reponse rep4 = new Reponse("rep4 q1", false, question);
		questionService.createOrUpdate(new Question("enonce q2",themeService.getById((long) 2)));
		questionService.createOrUpdate(new Question("enonce q3",themeService.getById((long) 2)));
		questionService.createOrUpdate(new Question("enonce q4",themeService.getById((long) 2)));
		questionService.createOrUpdate(new Question("enonce q5",themeService.getById((long) 2)));
		questionService.createOrUpdate(new Question("enonce q6",themeService.getById((long) 2)));
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
