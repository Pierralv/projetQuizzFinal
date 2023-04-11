package projetQuizz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Question;
import projetQuizz.entities.Reponse;
import projetQuizz.services.QuestionService;
import projetQuizz.services.ReponseService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
//@Rollback
class QuestionServiceTest {
	
	@Autowired
	QuestionService questionService;	
	@Autowired 
	ReponseService reponseService;
	
	private Question q = new Question("énoncéé", null);
	
	@Test
	void injectionQuestionServiceTest() {
		assertNotNull(questionService);
	}
	
	@Test
	@Commit
	void initQuestionReponse() {
		questionService.createOrUpdate(q);
		assertNotNull(questionService.getById(q.getId()));
		reponseService.createOrUpdate(new Reponse("énoncé de la réponse", false, q));
		reponseService.createOrUpdate(new Reponse("énoncé de la réponse", false, q));
		reponseService.createOrUpdate(new Reponse("énoncé de la réponse", false, q));
		reponseService.createOrUpdate(new Reponse("énoncé de la réponse", false, q));
		System.out.println(questionService.getAll());
		System.out.println(reponseService.getAll());
		System.out.println(questionService.getIdWithReponses(1L));	
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
