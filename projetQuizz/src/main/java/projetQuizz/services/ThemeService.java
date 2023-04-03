package projetQuizz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetQuizz.entities.Theme;
import projetQuizz.repositories.ThemeRepository;
import projetQuizz.exceptions.ThemeException;

@Service
public class ThemeService {
	@Autowired
	private ThemeRepository themeRepo;
	
	public List<Theme> getAll() {
		return themeRepo.findAll();
	}
	
	public Theme getById(Long id) {
		if (id == null) {
			throw new ThemeException("id obligatoire");
		}
		return themeRepo.findById(id).orElseThrow(() -> {
			throw new ThemeException ("id inconnu");
		});
	}
	
	public Theme getIdWithQuestions(Long id) {
		if (id == null) {
			throw new ThemeException("id obligatoire");
		}
		return themeRepo.findByIdFetchQuestions(id).orElseThrow(() -> {
			throw new ThemeException("id inconnu");
		});
	}
	
	public void delete(Theme theme) {
		deleteById(theme.getId());
	}
	
	public void deleteById(Long id) {
		themeRepo.delete(getById(id));
	}
	
	public void createOrUpdate(Theme theme) {
		if (theme.getNom() == null || theme.getNom().isBlank()) {
			throw new ThemeException("Nom obligatoire");
		}
		themeRepo.save(theme);
	}
	
	public List<Theme> getByNom(String nom) {
		return themeRepo.findByNomContaining(nom);
	}
	
	
}
