package projetQuizz;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import projetQuizz.config.JpaConfig;
import projetQuizz.entities.Theme;
import projetQuizz.services.QuestionService;
import projetQuizz.services.ThemeService;

@SpringJUnitConfig(JpaConfig.class)
@Transactional
public class ThemeServiceTest {	
	@Autowired
	ThemeService themeService;
	
	private Theme t = new Theme("nom");
	
	@Test
	void initTheme() {
		themeService.createOrUpdate(t);
		System.out.println(themeService.getAll());
		System.out.println(themeService.getById(1L));
		System.out.println(themeService.getIdWithQuestions(1L));
	}

}
