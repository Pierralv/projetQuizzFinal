package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
// import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Reponse;
import projetQuizz.services.ReponseService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
// @Rollback
class ReponseServiceTest {	
	@Autowired
	ReponseService reponseService;
	
	
	@Test
	@Commit
	void initReponse() {
		Reponse reponse = new Reponse("énoncéReponse1", true);
		reponseService.createOrUpdate(reponse);
	}
	
	@Test
	void getAllReponse() {
		System.out.println("------------getAll------------");
		System.out.println(reponseService.getAll());
	}
	
	@Test
	void getById() {
		System.out.println("------------getById------------");
		System.out.println(reponseService.getById(1L));
	}
	
    @Test
	void delete() {
		reponseService.deleteById(1L);
	}

}
