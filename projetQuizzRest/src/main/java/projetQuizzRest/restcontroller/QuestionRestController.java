package projetQuizzRest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetQuizz.entities.Question;
import projetQuizz.services.QuestionService;

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
	
	@GetMapping("/{if}/produits")
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
}
