package ajc.formation.soprasteria.projetQuizzSB.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.entities.Reponse;
import ajc.formation.soprasteria.projetQuizzSB.services.QuestionService;
import ajc.formation.soprasteria.projetQuizzSB.services.ReponseService;

@SpringBootTest
@Transactional
//@Rollback
class QuestionServiceTest {
	
	@Autowired
	QuestionService questionService;	
	@Autowired 
	ReponseService reponseService;
	
	private Question q = new Question("enoncee", null);
	
	@Test
	void injectionQuestionServiceTest() {
		assertNotNull(questionService);
	}
	
	@Test
	@Commit
	void initQuestionReponse() {
		questionService.createOrUpdate(q);
		assertNotNull(questionService.getById(q.getId()));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		reponseService.createOrUpdate(new Reponse("enonce de la reponse", false, q));
		System.out.println(questionService.getAll());
		System.out.println(reponseService.getAll());
		// System.out.println(questionService.getIdWithReponses(1L));	
		questionService.deleteById(1L);
	}


//	@Disabled
//	@Commit
//	@Test
//	void getAllQuestion() {
//		System.out.println(questionService.getAll());
//	}
//
//	@Commit
//	@Test
//	void getByIdQuestion() {
//		System.out.println(questionService.getAll());
//	}
//	
////	@Test
////	void deleteQuestion() {
////		questionService.deleteById(1L);
////	}
//	
//	@Test
//	void getByIdReponse() {
//		System.out.println(questionService.getIdWithReponses(1L));
//	}

}
