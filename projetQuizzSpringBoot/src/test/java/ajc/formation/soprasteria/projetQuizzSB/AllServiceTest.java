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
		//compte
		compteSrv.createAdmin(compte1);
		compteSrv.createUser(compte2);
		compteSrv.createUser(compte3);
		//theme
		themeService.createOrUpdate(theme);
		themeService.createOrUpdate(new Theme("histoire"));
		themeService.createOrUpdate(new Theme("musique"));
		//q1
		questionService.createOrUpdate(question);
		Reponse rep1 = new Reponse("rep1 q1", false, question);
		Reponse rep2 = new Reponse("rep2 q1", true, question);
		Reponse rep3 = new Reponse("rep3 q1", false, question);
		Reponse rep4 = new Reponse("rep4 q1", false, question);
		reponseService.createOrUpdate(rep1);
		reponseService.createOrUpdate(rep2);
		reponseService.createOrUpdate(rep3);
		reponseService.createOrUpdate(rep4);
		//q2
		questionService.createOrUpdate(new Question("enonce q2",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q2", false, questionService.getById(2L)));
		reponseService.createOrUpdate(new Reponse("r2q2", false, questionService.getById(2L)));
		reponseService.createOrUpdate(new Reponse("r3q2", true, questionService.getById(2L)));
		reponseService.createOrUpdate(new Reponse("r4q3", false, questionService.getById(2L)));
		//q3
		questionService.createOrUpdate(new Question("enonce q3",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q3", false, questionService.getById(3L)));
		reponseService.createOrUpdate(new Reponse("r2q3", false, questionService.getById(3L)));
		reponseService.createOrUpdate(new Reponse("r3q3", false, questionService.getById(3L)));
		reponseService.createOrUpdate(new Reponse("r4q3", true, questionService.getById(3L)));
		//q4
		questionService.createOrUpdate(new Question("enonce q4",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q4", true, questionService.getById(4L)));
		reponseService.createOrUpdate(new Reponse("r2q4", false, questionService.getById(4L)));
		reponseService.createOrUpdate(new Reponse("r3q4", false, questionService.getById(4L)));
		reponseService.createOrUpdate(new Reponse("r4q4", false, questionService.getById(4L)));
		//q5
		questionService.createOrUpdate(new Question("enonce q5",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q5", false, questionService.getById(5L)));
		reponseService.createOrUpdate(new Reponse("r2q5", true, questionService.getById(5L)));
		reponseService.createOrUpdate(new Reponse("r3q5", false, questionService.getById(5L)));
		reponseService.createOrUpdate(new Reponse("r4q5", false, questionService.getById(5L)));
		//q6
		questionService.createOrUpdate(new Question("enonce q6",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q6", false, questionService.getById(6L)));
		reponseService.createOrUpdate(new Reponse("r2q6", false, questionService.getById(6L)));
		reponseService.createOrUpdate(new Reponse("r3q6", true, questionService.getById(6L)));
		reponseService.createOrUpdate(new Reponse("r4q6", false, questionService.getById(6L)));
		//q7
		questionService.createOrUpdate(new Question("enonce q7",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q7", true, questionService.getById(7L)));
		reponseService.createOrUpdate(new Reponse("r2q7", false, questionService.getById(7L)));
		reponseService.createOrUpdate(new Reponse("r3q7", false, questionService.getById(7L)));
		reponseService.createOrUpdate(new Reponse("r4q7", false, questionService.getById(7L)));
		//q8
		questionService.createOrUpdate(new Question("enonce q8",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q8", false, questionService.getById(8L)));
		reponseService.createOrUpdate(new Reponse("r2q8", false, questionService.getById(8L)));
		reponseService.createOrUpdate(new Reponse("r3q8", true, questionService.getById(8L)));
		reponseService.createOrUpdate(new Reponse("r4q8", false, questionService.getById(8L)));
		//q9
		questionService.createOrUpdate(new Question("enonce q9",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q9", false, questionService.getById(9L)));
		reponseService.createOrUpdate(new Reponse("r2q9", true, questionService.getById(9L)));
		reponseService.createOrUpdate(new Reponse("r3q9", false, questionService.getById(9L)));
		reponseService.createOrUpdate(new Reponse("r4q9", false, questionService.getById(9L)));
		//q10
		questionService.createOrUpdate(new Question("enonce q10",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q10", false, questionService.getById(10L)));
		reponseService.createOrUpdate(new Reponse("r2q10", false, questionService.getById(10L)));
		reponseService.createOrUpdate(new Reponse("r3q10", false, questionService.getById(10L)));
		reponseService.createOrUpdate(new Reponse("r4q10", true, questionService.getById(10L)));
		//q11
		questionService.createOrUpdate(new Question("enonce q11",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q11", true, questionService.getById(11L)));
		reponseService.createOrUpdate(new Reponse("r2q11", false, questionService.getById(11L)));
		reponseService.createOrUpdate(new Reponse("r3q11", false, questionService.getById(11L)));
		reponseService.createOrUpdate(new Reponse("r4q11", false, questionService.getById(11L)));
		//q12
		questionService.createOrUpdate(new Question("enonce q12",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q12", false, questionService.getById(12L)));
		reponseService.createOrUpdate(new Reponse("r2q12", false, questionService.getById(12L)));
		reponseService.createOrUpdate(new Reponse("r3q12", true, questionService.getById(12L)));
		reponseService.createOrUpdate(new Reponse("r4q12", false, questionService.getById(12L)));
		//q13
		questionService.createOrUpdate(new Question("enonce q13",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q13", true, questionService.getById(13L)));
		reponseService.createOrUpdate(new Reponse("r2q13", false, questionService.getById(13L)));
		reponseService.createOrUpdate(new Reponse("r3q13", false, questionService.getById(13L)));
		reponseService.createOrUpdate(new Reponse("r4q13", false, questionService.getById(13L)));
		//q14
		questionService.createOrUpdate(new Question("enonce q14",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q14", false, questionService.getById(14L)));
		reponseService.createOrUpdate(new Reponse("r2q14", false, questionService.getById(14L)));
		reponseService.createOrUpdate(new Reponse("r3q14", true, questionService.getById(14L)));
		reponseService.createOrUpdate(new Reponse("r4q14", false, questionService.getById(14L)));
		//q15
		questionService.createOrUpdate(new Question("enonce q15",themeService.getById((long) 2)));
		reponseService.createOrUpdate(new Reponse("r1q15", true, questionService.getById(15L)));
		reponseService.createOrUpdate(new Reponse("r2q15", false, questionService.getById(15L)));
		reponseService.createOrUpdate(new Reponse("r3q15", false, questionService.getById(15L)));
		reponseService.createOrUpdate(new Reponse("r4q15", false, questionService.getById(15L)));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println(compteSrv.getAll());
//		System.out.println(compteSrv.getById(compte1.getId()));
//		System.out.println(themeService.getAll());
//		System.out.println(themeService.getById(theme.getId()));
//		System.out.println(themeService.getIdWithQuestions(theme.getId()));
//		System.out.println(questionService.getAll());
//		System.out.println(questionService.getById(question.getId()));
//		System.out.println(questionService.getIdWithReponses(question.getId()));
//		// System.out.println((questionService.getByCreateur(compte1))); 
//		System.out.println(reponseService.getAll());
//		System.out.println(reponseService.getById(rep1.getId()));
//		System.out.println(reponseService.getByEnonceContaining("reponse2"));
	}

}
