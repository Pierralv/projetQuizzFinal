package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Compte;
import projetQuizz.entities.Role;
import projetQuizz.services.CompteService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
//@Rollback
public class CompteServiceTest {
	
	@Autowired CompteService compteSrv;
	
	@Test
	@Commit
	void initCompte() {
		compteSrv.createOrUpdate(new Compte("nom", "prenom", "pseudo", "avatar", "email", "mdp", Role.ROLE_ADMIN));
		System.out.println("get by id:");
		System.out.println(compteSrv.getById(1L));
		System.out.println("get all");
		System.out.println(compteSrv.getAll());
	}
	
	
	
	

}
