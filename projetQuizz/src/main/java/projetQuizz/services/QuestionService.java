package projetQuizz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetQuizz.entities.Question;
import projetQuizz.exceptions.QuestionException;
import projetQuizz.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	public List<Question> getAll(){
		return questionRepo.findAll();
	}
	
	public Question getById(Long id) {
		if(id == null) {
			throw new QuestionException("id obligatoire");
		}
		return questionRepo.findById(id).orElseThrow(()-> {
			throw new QuestionException("id inconnu");
		});
	}
	
	public void delete (Question question) {
		deleteById(question.getId());
	}
	
	public void deleteById(Long id) {
		questionRepo.delete(getById(id));
	}
	
	public void createOrUpdate(Question question) {
		if (question.getEnonceQuestion() == null || question.getEnonceQuestion().isBlank()) {
			throw new QuestionException("Enoncé obligatoire");
		}
		questionRepo.save(question);
	}
	
	public List<Question> getByCreateur (String createur){
		return questionRepo.findByCreateurContaining(createur);
	}
	
}
