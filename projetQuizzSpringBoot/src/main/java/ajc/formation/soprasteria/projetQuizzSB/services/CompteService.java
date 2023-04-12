package ajc.formation.soprasteria.projetQuizzSB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.formation.soprasteria.projetQuizzSB.entities.Compte;
import ajc.formation.soprasteria.projetQuizzSB.exceptions.CompteException;
import ajc.formation.soprasteria.projetQuizzSB.repositories.CompteRepository;
import ajc.formation.soprasteria.projetQuizzSB.repositories.QuestionRepository;

@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	public List<Compte> getAll(){
		return compteRepo.findAll();
	}

	public Compte getById(Long id) {
		if (id==null) {
			throw new CompteException("id obligatoire");
		}
		return compteRepo.findById(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});
	}
	
	public Compte getByIdWithQuestions (Long id) {
		if(id ==null) {
			throw new CompteException("id obligatoire");
		}
		return compteRepo.findByIdFetchQuestions(id).orElseThrow(() -> {
			throw new CompteException("id inconnu");
		});
	}
	
	public void delete(Compte compte) {
		deleteById(compte.getId());
	}
	
	public void deleteById(Long id) {
		Compte c = getById(id);
		questionRepo.setCreateurToNullByCreateur(c);
		compteRepo.deleteById(id);
		
	}
	
	public void createOrUpdate(Compte compte) {
		if(compte.getEmail() == null || compte.getEmail().isBlank()) {
			throw new CompteException("email obligatoire");
		}
		if(compte.getPseudo() == null || compte.getPseudo().isBlank()) {
			throw new CompteException("pseudo invalide");
		}
		if(compte.getRole() == null) {
			throw new CompteException("probleme role");
		}
		compteRepo.save(compte);
	}
	
	
	
	
}
