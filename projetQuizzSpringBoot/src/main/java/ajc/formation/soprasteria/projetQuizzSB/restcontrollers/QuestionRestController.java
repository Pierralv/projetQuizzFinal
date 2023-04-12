package ajc.formation.soprasteria.projetQuizzSB.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.services.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {
	
	@Autowired
	private QuestionService questionSrv;
	
	@GetMapping("/all")
	//jsonview
	public List<Question> getAll(){
		return questionSrv.getAll();
	}
	
	@GetMapping("/{id}")
	//jsonview
	public Question getById(@PathVariable Long id) {
		Question question = null;
		question = questionSrv.getById(id);
		return question;
	}
	
	@GetMapping("/{id}/produits")
	//jsonview
	public Question getByIdWithReponses(@PathVariable Long id) {
		Question question = null;
		question = questionSrv.getIdWithReponses(id);
		return question;
	}
	
	@PostMapping("")
	//jsonview
	@ResponseStatus(code = HttpStatus.CREATED)
	public Question create(@RequestBody Question question) {
//		if (br.hasErrors()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
		questionSrv.createOrUpdate(question);
		return question;
	}
	
	@PutMapping("{id}")
	//jsonview
	public Question update(@RequestBody Question question, @PathVariable Long id) {
		Question questionEnBase = questionSrv.getById(id);
		if (question.getEnonceQuestion() != null) {
			questionEnBase.setEnonceQuestion(question.getEnonceQuestion());
		}
		if (question.getTheme() != null) {
			questionEnBase.setTheme(question.getTheme());
		}
		questionSrv.createOrUpdate(questionEnBase);
		return questionEnBase;
	}
	
	@DeleteMapping("{id}")
	//jsonview
	@ResponseStatus(code =HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		questionSrv.deleteById(id);
	}
}
