package ajc.formation.soprasteria.projetQuizzSB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetQuizzSB.entities.Compte;
import ajc.formation.soprasteria.projetQuizzSB.entities.Question;
import ajc.formation.soprasteria.projetQuizzSB.entities.Theme;
import ajc.formation.soprasteria.projetQuizzSB.exceptions.QuestionException;
import ajc.formation.soprasteria.projetQuizzSB.repositories.QuestionRepository;
import ajc.formation.soprasteria.projetQuizzSB.repositories.ReponseRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private ReponseRepository reponseRepo;
	
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
		Question q = getById(id);
		reponseRepo.deleteByQuestion(q);
		questionRepo.deleteById(id);
	}
	
	public Question createOrUpdate(Question question) {
		if (question.getEnonceQuestion() == null || question.getEnonceQuestion().isBlank()) {
			throw new QuestionException("Enonce obligatoire");
		}
		return questionRepo.save(question);
	}
	
	public List<Question> getByCreateur (Compte createur){
		return questionRepo.findByCreateur(createur);
	}

	public List<Question> getByTheme (Theme theme){
		return questionRepo.findByTheme(theme);
	}
	
	public Question getIdWithReponses(Long id) {
		if (id == null) {
			throw new QuestionException("id obligatoire");
		}
		return questionRepo.findByIdFetchReponses(id).orElseThrow(() -> {
			throw new QuestionException("id inconnu");
		});
	}
	
}
