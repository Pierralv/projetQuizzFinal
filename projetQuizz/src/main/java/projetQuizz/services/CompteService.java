package projetQuizz.services;

import java.util.List;

import projetQuizz.entities.Compte;
import projetQuizz.exceptions.CompteException;
import projetQuizz.repositories.CompteRepository;

public class CompteService {
	
	private CompteRepository compteRepo;
	
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
	
	public void delete(Compte compte) {
		deleteById(compte.getId());
	}
	
	public void deleteById(Long id) {
		compteRepo.delete(getById(id));
	}
	
	public void createOrUpdate(Compte compte) {
		if(compte.getEmail() == null || compte.getEmail().isBlank()) {
			throw new CompteException("email obligatoire");
		}
		if(compte.getPseudo() == null || compte.getPrenom().isBlank()) {
			throw new CompteException("pseudo invalide");
		}
		if(compte.getRole() == null) {
			throw new CompteException("problème role");
		}
	}
	
	
	
	
}
