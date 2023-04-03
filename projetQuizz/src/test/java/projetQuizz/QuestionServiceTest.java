package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Question;
import projetQuizz.services.QuestionService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
class QuestionServiceTest {
	
	@Autowired
	QuestionService questionService;
	
	
	@Test
	void initQuestion() {
		questionService.createOrUpdate(new Question("énoncéé", null));		
	}
	
//	@Test
//	@Commit
//	void deleteQuestion() {
//		questionService.deleteById(1L);
//	}
	
	@Test
	@Commit
	void getAllQuestion() {
		System.out.println(questionService.getAll());
	}
	
	@Test
	void getByIdQuestion() {
		System.out.println(questionService.getById(1L));
	}
	
	@Test
	void deleteQuestion() {
		questionService.deleteById(1L);
	}

}
